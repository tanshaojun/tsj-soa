import requests
import random
from lxml import etree

pro = ['183.179.199.225:8080']
ip = random.sample(pro, 1)[0]
url = "https://movie.douban.com/top250??start=50&amp;filter="
html = requests.get(url, proxies={"https": "https://" + ip}).text
print(html)
info = etree.HTML(html)
title=info.xpath('//span[@class="title"]/text()')
print(title)
title1=info.xpath('//span[@class="inq"]/text()')
print(title1)
