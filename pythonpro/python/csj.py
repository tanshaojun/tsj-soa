import requests
from lxml import etree

response = requests.get("https://www.pangle.cn/help/doc/5fbdb6811ee5c2001d3f0ca5")
info = etree.HTML(response.text)
trs = info.xpath("//tr")
for tr in trs:
    tr = tr.xpath("./td/text()")
    if len(tr) > 0:
        print(tr[0])
        print(tr[1])
