from scrapy.cmdline import execute

spiders = [
    'scrapy crawl orange_spider'
]

if __name__ == '__main__':
    for i in spiders:
        execute(i.split())
