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
    url = "https://bj.lianjia.com/zufang/changping/pg%s/"
    count = 1
    start_urls = [url % (count)]

    def parse(self, response):
        lis = response.xpath("//li[@data-el='zufang']")
        if len(lis) > 0:
            for li in lis:
                nexturl = li.xpath("./div[@class='pic-panel']/a/@href").extract()[0]
                if nexturl != "":
                    yield scrapy.Request(nexturl, meta={'info': nexturl}, callback=self.parseInfo, dont_filter=True)
            if self.count <= 100:
                self.count += 1
                yield scrapy.Request(self.url % (self.count), callback=self.parse, dont_filter=True)
        else:
            print("不知道为什么失败了")

    sql = "insert into house(price, renovation, area, huxing, floor, direction, subway, housing, address, t, name,phone,info,idkey,created) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"

    def parseInfo(self, response):
        if response.status == 200:
            lj = LianJia()
            # 时间
            t = response.xpath("//div[@class='zf-room']/p[8]/text()").extract()[0]
            t = re.sub("[天前发布]", "", t)
            if int(t) <= 30:
                lj['t'] = t
                # 价格
                price = response.xpath("//span[@class='total']/text()").extract()[0]
                # 装修方式
                renovation = response.xpath("//span[@class='tips decoration']/text()").extract()
                if len(renovation) == 0:
                    renovation = "无"
                else:
                    renovation = renovation[0]
                # 面积
                area = response.xpath("//div[@class='zf-room']/p[1]/text()").extract()[0]
                # 户型
                huxing = response.xpath("//div[@class='zf-room']/p[2]/text()").extract()[0]
                # 楼层
                floor = response.xpath("//div[@class='zf-room']/p[3]/text()").extract()[0]
                # 朝向
                direction = response.xpath("//div[@class='zf-room']/p[4]/text()").extract()[0]
                # 地铁
                subway = response.xpath("//div[@class='zf-room']/p[6]/text()").extract()[0].strip()
                # 小区
                housing = response.xpath("//div[@class='zf-room']/p[6]/a/text()").extract()
                housing = "-".join(housing)
                # 位置
                address = response.xpath("//div[@class='zf-room']/p[7]/a/text()").extract()
                address = "-".join(address)
                # 姓名
                name = response.xpath("//div[@class='brokerName']/a[1]/text()").extract()[0]
                # 电话
                phone = response.xpath("//div[@class='phone']/text()").extract()
                phone0 = phone[0].strip()
                phone1 = phone[1].strip()
                phone = phone0 + "  转  " + phone1
                # 详情
                info = response.meta['info']
                # key
                idkey = re.findall("\d+", info)[0]

                lj['price'] = price
                lj['renovation'] = renovation
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

                created = datetime.datetime.now()

                try:
                    conn = pymysql.connect(host='localhost', user='root', passwd='root', db='blog', port=3306,
                                           charset='utf8')
                    cur = conn.cursor()
                    cur.execute(self.sql,
                                [price, renovation, area, huxing, floor, direction, subway, housing, address, t, name,
                                 phone, info, idkey, created])
                    conn.commit()
                except Exception:
                    print("失败")
                yield lj
            else:
                print("时间已大于30天，就不需要了")
        else:
            print("不知道为什么失败了")
