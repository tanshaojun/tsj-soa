# -*- coding: utf-8 -*-
import scrapy
import pymysql
from python_scrapy.items import FangTianXia


class PythonScrapyFangTianXiaSpider(scrapy.Spider):
    # 爬虫名
    name = 'python_scrapy_fangtianxia'
    # 爬虫范围
    allowed_domains = ['zu.fang.com']
    url = "http://zu.fang.com/house1-j011/%s%s"
    count = 31
    start_urls = [url % ("", "")]

    def parse(self, response):
        eachs = response.xpath("//dl[@class='list hiddenMap rel']")
        for each in eachs:
            # 初始化对象
            link = each.xpath("./dd[@class='info rel']/p[1]/a/@href").extract()
            link1 = each.xpath("./dd[@class='info rel']/p[1]/a/@data_channel").extract()
            if len(link) > 0:
                linkurl = "http://zu.fang.com" + link[0] + "?channel=" + link1[0]
                yield scrapy.Request(linkurl, callback=self.parseCallback, dont_filter=True)
        if self.count <= 100:
            self.count += 1
            # 处理完请求下一页
            newurl = self.url
            newurl = newurl % ("i3", self.count)
            yield scrapy.Request(newurl, callback=self.parse, dont_filter=True)

    sql = "insert into house(price,mode,direction,huxing,floor,area,renovation,address,phone,name) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"

    def parseCallback(self, response):
        o = FangTianXia()

        # 价格
        price= response.xpath("//div[@class='trl-item sty1']/i/text()").extract()[0]
        o['price'] = price

        modedirection = response.xpath("//div[@class='trl-item1 w146']")
        # 出租方式
        mode= modedirection[0].xpath("./div[@class='tt']/text()").extract()[0]
        o['mode'] = mode
        # 朝向
        direction = modedirection[1].xpath("./div[@class='tt']/text()").extract()[0]
        o['direction'] = direction
        huxingfloor = response.xpath("//div[@class='trl-item1 w182']")
        # 户型
        huxing = huxingfloor[0].xpath("./div[@class='tt']/text()").extract()[0]
        o['huxing'] = huxing
        # 楼层
        floor = huxingfloor[1].xpath("./div[@class='tt']/text()").extract()[0]
        o['floor'] = floor
        arearenovation = response.xpath("//div[@class='trl-item1 w132']")
        # 面积
        area = arearenovation[0].xpath("./div[@class='tt']/text()").extract()[0]
        o['area'] = area
        # 装修
        renovation = arearenovation[1].xpath("./div[@class='tt']/text()").extract()[0]
        o['renovation'] = renovation
        address = response.xpath("//div[@class='trl-item2 clearfix']")
        # 地址
        address = address[2].xpath("./div[@class='rcont']/a/text()").extract()[0]
        o['address'] = address
        # 电话号码
        phone = response.xpath("//div[@class='tjcont-list-cline2 tjcont_gs clearfix']/p[@class='text_phone']/text()").extract()[0]
        o['phone'] = phone
        # 姓名
        name = response.xpath("//div[@class='tjcont-list-cline1 tjcont_line']/span/a/text()").extract()[0]
        o['name'] = name
        try:
            conn = pymysql.connect(host='localhost',user='root',passwd='root',db='blog',port=3306,charset='utf8')
            cur = conn.cursor()
            cur.execute(self.sql,[price,mode,direction,huxing,floor,area,renovation,address,phone,name])
            conn.commit()
        except Exception:
            print("失败")
        yield o
