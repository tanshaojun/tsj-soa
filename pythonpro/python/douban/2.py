import requests
from bs4 import BeautifulSoup
import random
from lxml import etree


def logToFile(content, filename):
    f = open(filename, 'a', encoding='utf8')
    try:
        f.write(content + '\n')
    except:
        print('写入失败')
    finally:
        f.close()

pro = ['183.179.199.225:8080']


count = 0
for num in range(0, 13):
    sum = num * 20
    ip = random.sample(pro, 1)[0]
    url = "https://movie.douban.com/subject/26602244/discussion/?start=" + str(sum) + "&sort_by=time"
    wbdata = requests.get(url, proxies={"https": "https://" + ip}).text
    soup = BeautifulSoup(wbdata, 'lxml')
    news_titles = soup.select("div.discussion-posts > table.olt")
    for table in news_titles:
        tr = table.findAll('tr')
        for t in tr:
            td = t.findAll('td')
            for d in td:
                a = d.findAll('a')
                for aa in a:
                    title = aa.get('title')
                    if title:
                        count += 1
                        logToFile(str("帖子" + str(count) + "标题：" + title), str("2.txt"))
                        href = aa.get('href')
                        wbdata = requests.get(href).text
                        soup = BeautifulSoup(wbdata, 'lxml')
                        new_titles = soup.select("div.comment-item")
                        for new_titless in new_titles:
                            pinglun = new_titless.findAll('p')[0].getText()
                            logToFile(str("帖子" + str(count) + "的评论：" + pinglun), str("2.txt"))
