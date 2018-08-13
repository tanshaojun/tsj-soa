import requests
import random
from lxml import etree


def logToFile(content, filename='doubantop.txt'):
    f = open(filename, 'a', encoding='utf8')
    try:
        f.write(content + '\n')
    except:
        print('写入失败')
    finally:
        f.close()


pro = ['183.179.199.225:8080']
# aa = ['117.64.235.59:808', '114.215.95.188:3128', '123.131.44.228:9999']
# 头信息
# head = {
#     'user-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'
# }

http = "http://" + random.sample(pro, 1)[0]
count = 0
for i in range(0, 10):
    i *= 25
    url = "https://movie.douban.com/top250?start=" + str(i) + "&filter="
    # 使用代理ip
    wbdata = requests.get(url, proxies={"https": http}).text
    # wbdata = requests.get(url).content
    # 对获取到的文本进行解析
    info = etree.HTML(wbdata)
    title = info.xpath('//p[@class="quote"]/span[1]/text()')
    print(title)
    # soup = BeautifulSoup(wbdata, 'lxml')
    # news_titles = soup.select("div.info")
    # for data in news_titles:
    #     count += 1
    #     span = data.findAll('span')
    #     name = span[0].getText()
    #     score = span[len(span) - 4].getText()
    #     evaluatenumber = span[len(span) - 2].getText()
    #     introduction = span[len(span) - 1].getText()
    #     json = "ranking：" + str(count) + ",name：" + str(name) + ",score：" + str(score) + ",evaluatenumber：" + str(
    #         evaluatenumber) + ",introduction：" + str(introduction)
    #     print(json)
    #     logToFile(json)
