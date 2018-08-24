# -*- coding: utf-8 -*-
import scrapy
from python_scrapy.items import PythonScrapyItem


class PythonScrapyOneSpider(scrapy.Spider):
    # 爬虫名
    name = 'python_scrapy_one'
    # 爬虫范围
    allowed_domains = ['tencent.com']

    start_urls = ['http://hr.tencent.com/position.php?&start=0']

    aa = 0

    def parse(self, response):
        for each in response.xpath("//tr[@class='even'] | //tr[@class='odd']"):
            # 初始化对象
            ps = PythonScrapyItem()
            ps['name'] = each.xpath("./td[1]/a/text()").extract()[0]
            yield ps
        # yield scrapy.Request('http://hr.tencent.com/position.php?&start=10', callback=self.parse, dont_filter=True)
