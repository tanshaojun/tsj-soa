import requests
from bs4 import BeautifulSoup
import random


def logToFile(content, filename='all.txt'):
    f = open(filename, 'a', encoding='utf8')
    try:
        f.write(content + '\n')
    except:
        print('写入失败')
    finally:
        f.close()


pro = ['118.212.137.135:31288', '123.131.44.228:9999', '183.167.217.152:63000', '101.37.79.125:3128',
       '117.64.235.59:808', '114.215.95.188:3128', '14.118.254.125:6666', '14.118.254.149:6666', '14.118.254.214:6666',
       '61.158.187.157:8080', '114.215.95.188:3128', '114.215.95.188:3128', '115.233.209.134:3128',
       '117.86.11.168:18118', '113.200.241.202:63000', '101.37.79.125:3128', '114.228.75.196:6666']
# 头信息
head = {
    'user-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'
}
http = ""
sum = 0
for count in range(0, 80000):
    count *= 20
    url = "https://movie.douban.com/j/new_search_subjects?sort=T&range=0,10&tags=%E7%94%B5%E5%BD%B1&start=" + str(count)
    success = ""
    while (True):
        try:
            if http == "":
                http = "http://" + random.sample(pro, 1)[0]
            wbdata = requests.get(url, proxies={"https": http}).json()
            lists = wbdata.get('data')
            success = http
            break
        except:
            if sum == 5:
                http = success
                sum = 0
            else:
                http = ""
                sum += 1
            print("请求异常")
    for l in lists:
        rate = l.get('rate')
        title = l.get('title')
        url = l.get('url')
        json = "name：" + str(title) + ",score：" + str(rate) + ",url：" + str(url)
        print(json)
        logToFile(json)
