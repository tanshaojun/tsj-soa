# -*- coding: utf-8 -*-
import scrapy
from python_scrapy.items import PythonScrapyItem


class PythonScrapyOneSpider(scrapy.Spider):
    # 爬虫名
    name = 'python_scrapy_one'
    # 爬虫范围
    allowed_domains = ['movie.douban.com']
    url = "https://movie.douban.com/top250?start=%d&filter="
    count = 0
    start_urls = [url % (count)]

    aa = 0

    def parse(self, response):
        for each in response.xpath("//div[@class='hd']"):
            # 初始化对象
            ps = PythonScrapyItem()
            print(each.xpath("./a/span[1]/text()").extract()[0].strip())
            ps['name'] = each.xpath("./a/span[1]/text()").extract()[0].strip()
            yield ps

        if self.count < 225:
            self.count += 25
            # 处理完请求下一页
            yield scrapy.Request(self.url % (self.count), callback=self.parse, dont_filter=True)
