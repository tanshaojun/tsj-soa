import requests
from lxml import etree
from PIL import Image
import pytesseract

html = requests.get("http://47.93.54.20/login").text
info = etree.HTML(html)
src = info.xpath('//img/@src')[1]
print(src)
im = Image.open("C:\\Users\\lenovo\\Desktop\\1.png")
ss = pytesseract.image_to_string(im)
data = {'username': 'admin',
        'password': 'yuseen',
        'validatecode': 'l12c'
        }
print(data)
headers = {
    'User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'}
login_url = 'http://47.93.54.20/login'
session = requests.Session()
resp = session.post(login_url, data)
url = 'http://47.93.54.20/index'
resp = session.get(url)
print(resp.content.decode('utf-8'))
