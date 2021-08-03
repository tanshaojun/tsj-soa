from scrapy.cmdline import execute

spiders = [
    'scrapy crawl python_scrapy_fangtianxia'
]

if __name__ == '__main__':
    for i in spiders:
        execute(i.split())
