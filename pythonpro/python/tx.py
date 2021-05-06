import requests
from lxml import etree

response = requests.get("https://developers.adnet.qq.com/doc/android/union/union_version")
info = etree.HTML(response.text)
trs = info.xpath("//tr")
for tr in trs:
    tr = tr.xpath("./td/text()")
    if len(tr) >0:
        print(tr[0])
        print(tr[1])