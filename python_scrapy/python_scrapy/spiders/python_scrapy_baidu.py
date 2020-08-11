# -*- coding: utf-8 -*-
import scrapy
import pymysql
import re
import datetime
from python_scrapy.items import LianJia


class PythonScrapyLianJiaSpider(scrapy.Spider):
    # 爬虫名
    name = 'python_scrapy_lianjia'
    # 爬虫范围
    allowed_domains = ['bj.lianjia.com']
    url = "https://bj.lianjia.com/zufang/changping/pg%d/#contentList"
    count = 1
    start_urls = [url % (count)]
    print(start_urls)

    def parse(self, response):
        lis = response.xpath("//p[@class='content__list--item--title twoline']")
        if len(lis) > 0:
            for li in lis:
                nexturl = li.xpath("./a/@href").extract()[0]
                if nexturl != "":
                    nexturl = "https://bj.lianjia.com" + nexturl
                    yield scrapy.Request(nexturl, meta={'info': nexturl}, callback=self.parseInfo, dont_filter=True)
            if self.count <= 100:
                self.count += 1
                yield scrapy.Request(self.url % (self.count), callback=self.parse, dont_filter=True)
        else:
            print("不知道为什么失败了")

    insert_sql = "insert into house(price, renovation, area, huxing, floor, direction, subway, housing, address, t, name,phone,info,idkey,created) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
    update_sql = "update house set price=%s, renovation=%s, area=%s, huxing=%s, floor=%s, direction=%s, subway=%s, housing=%s, address=%s, t=%s, name=%s,phone=%s,info=%s WHERE idkey = %s"
    select_sql = "select * from house WHERE idkey = %s"

    def parseInfo(self, response):
        if response.status == 200:
            lj = LianJia()
            # 时间
            t = response.xpath("//li[@class='fl oneline']")
            day = t[1].xpath("./text()").extract()[0]
            day = re.sub("[天前：发布]", "", day)
            if int(day) <= 30:
                lj['t'] = day
                # 价格
                price = response.xpath("//p[@class='content__aside--title']/span/text()").extract()[0]
                areas = response.xpath("//p[@class='content__article__table']")
                # 面积
                area = areas[0].xpath("./span[3]/text()").extract()[0]
                # 户型
                huxing = areas[0].xpath("./span[2]/text()").extract()[0]
                # 楼层
                floor = t[7].xpath("./text()").extract()[0]
                # 朝向
                direction = areas[0].xpath("./span[4]/text()").extract()[0]
                # 地铁
                subway = ""
                # 小区
                housing = ""
                # 位置
                address = ""
                # 姓名
                name = ""
                # 电话
                phone = ""
                renovation = ""
                # 详情
                info = response.meta['info']
                # key
                idkey = re.findall("\d+", info)[0]

                lj['price'] = price
                lj['renovation'] = ""
                lj['area'] = area
                lj['huxing'] = huxing
                lj['floor'] = floor
                lj['direction'] = direction
                lj['subway'] = subway
                lj['housing'] = housing
                lj['address'] = address
                lj['name'] = name
                lj['phone'] = phone
                # 详情
                lj['info'] = info
                # 创建时间
                created = datetime.datetime.now()

                try:
                    conn = pymysql.connect(host='localhost', user='root', passwd='root', db='blog', port=3306,
                                           charset='utf8')
                    cur = conn.cursor()
                    cur.execute(self.select_sql, [idkey])
                    result = cur.fetchone()
                    if result is not None:
                        cur.execute(self.update_sql,
                                    [price, renovation, area, huxing, floor, direction, subway, housing, address, t,
                                     name, phone, info, idkey])
                        conn.commit()
                    else:
                        cur.execute(self.insert_sql,
                                    [price, renovation, area, huxing, floor, direction, subway, housing, address, t,
                                     name, phone, info, idkey, created])
                        conn.commit()
                except Exception:
                    print(Exception)
                    print("失败")
                yield lj
            else:
                print("时间已大于30天，就不需要了")
        else:
            print("不知道为什么失败了")
