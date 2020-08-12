# -*- coding: utf-8 -*-
import scrapy

from python_scrapy.items import Url


class PythonScrapyLianJiaSpider(scrapy.Spider):
    name = "orange_spider"
    allowed_domains = ["baidu.com"]
    start_urls = ['http://baike.baidu.com/item/橘子水']

    def start_requests(self):
        yield scrapy.Request(url=self.start_urls[0], callback=self.parse,
                             meta={"url": self.start_urls[0]})

    def parse(self, response):
        item = Url()
        item["url"] = response.meta["url"]
        title = response.xpath('//title/text()').extract()
        if title:
            item["title"] = title[0]
        else:
            return
        hrefs = response.xpath('//div[@class="main-content"]//a/@href')
        # yield item
        for href in hrefs:
            new_url = href.extract()
            if "view" in new_url or "item" in new_url:
                print(new_url)
                yield scrapy.Request(url="http://baike.baidu.com" + new_url, callback=self.parse,
                                     meta={"url": "http://baike.baidu.com" + new_url})
