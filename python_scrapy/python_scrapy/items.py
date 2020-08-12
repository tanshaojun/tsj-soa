# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class PythonScrapyItem(scrapy.Item):
    # define the fields for your item here like:
    name = scrapy.Field()
    pass


class FangTianXia(scrapy.Item):
    # define the fields for your item here like:
    price = scrapy.Field()
    mode = scrapy.Field()
    huxing = scrapy.Field()
    area = scrapy.Field()
    direction = scrapy.Field()
    floor = scrapy.Field()
    renovation = scrapy.Field()
    address = scrapy.Field()
    phone = scrapy.Field()
    name = scrapy.Field()
    pass


class LianJia(scrapy.Item):
    # define the fields for your item here like:
    price = scrapy.Field()
    renovation = scrapy.Field()
    area = scrapy.Field()
    huxing = scrapy.Field()
    floor = scrapy.Field()
    direction = scrapy.Field()
    subway = scrapy.Field()
    housing = scrapy.Field()
    address = scrapy.Field()
    t = scrapy.Field()
    phone = scrapy.Field()
    name = scrapy.Field()
    info = scrapy.Field()
    pass

class Url(scrapy.Item):
    url = scrapy.Field()
    title = scrapy.Field()
    pass