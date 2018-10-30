# -*- coding: utf-8 -*-
import scrapy
from python_scrapy.items import FangTianXia


class PythonScrapyFangTianXiaSpider(scrapy.Spider):
    # 爬虫名
    name = 'python_scrapy_fangtianxia'
    # 爬虫范围
    allowed_domains = ['zu.fang.com']
    url = "http://zu.fang.com/house1-j011/"
    start_urls = [url]

    def parse(self, response):
        eachs = response.xpath("//dl[@class='list hiddenMap rel']")
        for each in eachs:
            # 初始化对象
            link = each.xpath("./dd[@class='info rel']/p[1]/a/@href").extract()
            link1 = each.xpath("./dd[@class='info rel']/p[1]/a/@data_channel").extract()
            if len(link) > 0:
                url = "http://zu.fang.com" + link[0] + "?channel=" + link1[0]
                yield scrapy.Request(url, callback=self.parse_callbak, dont_filter=True)

    def parse_callbak(self, response):
        o = FangTianXia()
        o['price'] = response.xpath("//div[@class='trl-item sty1']/i/text()").extract()[0]
        yield o
