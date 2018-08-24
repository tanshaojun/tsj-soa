# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html
import json


class PythonScrapyPipeline(object):
    def __init__(self):
        self.filename = open("1.txt", 'wb')

    def process_item(self, item, spider):
        # 加入ensure_ascii=False输出到汉字为中文
        text = json.dumps(dict(item), ensure_ascii=False)
        self.filename.write(text.encode("utf-8"))
        return item

    def close_spider(self, spider):
        self.filename.close()
