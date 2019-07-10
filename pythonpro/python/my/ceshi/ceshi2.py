import requests
from bs4 import BeautifulSoup

url = 'http://www.baidu.com.cn/s?wd=区块链开发&pn='
wbdata = requests.get(url).text
soup = BeautifulSoup(wbdata, 'lxml')
news_titles = soup.select("div#3001")
for table in news_titles:
    tr = table.findAll('a')
    for t in tr:
        print(t)
        print("--------------------------------------------------------------------------------")
