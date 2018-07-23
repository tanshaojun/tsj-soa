import requests
from bs4 import BeautifulSoup
import re

l = []


def data(news_titles):
    trs = news_titles[0].findAll("tbody")[0].findAll("tr")
    for tr in trs:
        tds = tr.findAll("td")
        if tds != []:
            data = {
                'id': tds[0].getText().strip(),
                'name': tds[1].getText().strip(),  # 名称
                'marketvalue': tds[2].getText().strip(),  # 流通市值
                'price': tds[3].getText(),  # 价格
                'circulationnumber': tds[4].getText().strip(),  # 流通数量
                'turnover': tds[5].get_text(),  # 成交额
                'increase': tds[6].getText(),  # 涨幅
            }
            print(data)
            l.append(data)


url = "https://www.feixiaohao.com"
soup = BeautifulSoup(requests.get(url).text, 'lxml')
# 抓取有多少页
countLabel = soup.find_all(class_=re.compile('new-page-list'))
aList = countLabel[0].findAll("a")
count = int(aList[len(aList) - 2].getText())
i = 1
while i <= count:
    soup = BeautifulSoup(requests.get("https://www.feixiaohao.com/list_" + str(i) + ".html").text, 'lxml')
    news_titles = soup.find_all(class_=re.compile('new-table new-coin-list'))
    data(news_titles)
    i = i + 1
