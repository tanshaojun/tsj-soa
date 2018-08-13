import requests
from bs4 import BeautifulSoup

url = "http://www.bishijie.com/hangqing/coin/bitcoin"
# 请求腾讯新闻的URL，获取其text文本
wbdata = requests.get(url).text
# 对获取到的文本进行解析
soup = BeautifulSoup(wbdata, 'html.parser')
# print(soup)
# 从解析文件中通过select选择器定位指定的元素，返回一个列表
news_titles = soup.select("div > table > tbody > tr")
for c in news_titles:
    print(c)
    print("--------------------------")
# print(news_titles)

# 对返回的列表进行遍历
# for n in news_titles:
#     # 提取出标题和链接信息
#     title = n.get_text()
#     link = n.get("href")
#     data = {
#         '标题': title,
#         '链接': link
#     }
#     print(data)
