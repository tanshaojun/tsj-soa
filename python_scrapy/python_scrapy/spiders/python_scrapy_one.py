# -*- coding: utf-8 -*-
import scrapy
from python_scrapy.items import PythonScrapyItem


class PythonScrapyOneSpider(scrapy.Spider):
    # 爬虫名
    name = 'python_scrapy_one'
    # 爬虫范围
    allowed_domains = ['movie.douban.com']

    start_urls = ['https://movie.douban.com/chart']

    aa = 0

    def parse(self, response):
        for each in response.xpath("//tr[@class='item']"):
            # 初始化对象
            ps = PythonScrapyItem()
            print(each.xpath("./td[2]/div/a/text()").extract()[0].strip())
            ps['name'] = each.xpath("./td[2]/div/a/text()").extract()[0].strip()
            yield ps
        # yield scrapy.Request('http://hr.tencent.com/position.php?&start=10', callback=self.parse, dont_filter=True)
