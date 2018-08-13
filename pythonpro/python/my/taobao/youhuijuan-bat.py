import random
import queue
import time
import requests
from lxml import etree
import xlwt
from threading import Thread
import json

line = 1
wb = xlwt.Workbook(encoding='utf-8')
ws = wb.add_sheet('优惠券')
path = '优惠券.xls'
filename = "1.txt"
head = ['序号', '商品类型', '商品名称', '优惠券', '券后价', '在售价', '销量', '推荐理由', '商品链接']
for i in range(9):
    ws.write(0, i, head[i])
pro = ['124.235.208.252', '218.60.8.99', '218.60.8.83', '101.231.188.78', '113.200.56.13', '221.228.17.172',
       '119.188.162.165', '114.113.126.83', '119.27.177.169', '123.139.56.238', '221.7.255.168', '222.170.0.102',
       '218.60.8.98']


def logToFile(content, filename):
    f = open(filename, 'a', encoding='utf8')
    try:
        print(content)
        f.write(content + '\n')
    except:
        print('写入失败')
    finally:
        f.close()


def getData(i):
    global line
    time.sleep(5 + random.random())
    k = 1
    lis = []
    print('【开始下载】第%d页数据' % i)
    htm = requests.get(url + '/index.php?r=l&page={}'.format(str(i)),
                       proxies={"https": "http://" + random.sample(pro, 1)[0]},
                       headers=headers)
    htm.encoding = 'utf-8'
    data = etree.HTML(htm.text)
    url_sps = data.xpath('//div[@class="title"]/a/@href')
    for url_sp in url_sps:  # 一页100条
        time.sleep(5 + random.random())
        print('      【正在下载】第%03d页第%03d条商品数据' % (i, k), end='')
        k += 1
        html_sp = requests.get(url + url_sp, proxies={"https": "http://" + random.sample(pro, 1)[0]},
                               headers=headers)
        html_sp.encoding = 'utf-8'
        info = etree.HTML(html_sp.text)
        title = info.xpath('//span[@class="title"]/text()')  # 产品
        summary = [x.replace('推荐理由：', '') for x in info.xpath('//span[@class="theme-color-3"]/text()')]  # 推荐理由
        category = info.xpath('//div[@class="nav-wrap"]/div/a[3]/text()')  # 类别
        now_price = info.xpath('//span[@class="now-price"]/b[2]/i/text()')  # 券后价
        old_price = info.xpath('//span[@class="org-price"]/i/text()')  # 在售价
        nums = info.xpath('//div[@class="text-wrap"]/span[2]/i/text()')  # 销量
        coupon = info.xpath('//div[@class="buy-coupon theme-color-8"]/span/b/text()')  # 优惠券
        sp_url = info.xpath('//a[@class="theme-bg-color-8"]/@href')  # 链接
        # lis.append(category + title + coupon + now_price + old_price + nums + summary + sp_url)
        data = {
            'category': category,
            'title': title[0],
            'coupon': coupon[0],
            'now_price': now_price[0],
            'old_price': old_price[0],
            'nums': nums[0],
            'summary': summary[0],
            'sp_url': sp_url[0],
        }
        url1 = "http://localhost:8011/testinst?title=" + title[0] + "&now_price=" + now_price[0] + "&old_price=" + \
               old_price[0] + "&coupon=" + coupon[0] + "&summary=" + summary[0] + "&sp_url=" + sp_url[0]
        header = {}
        requests.get(url1, headers=header)


class threadDownload(Thread):
    def __init__(self, que):
        Thread.__init__(self)
        self.que = que

    def run(self):
        while True:
            if not self.que.empty():
                getData(self.que.get())
            else:
                break


if __name__ == '__main__':
    my_queue = queue.Queue()
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0'}
    url = 'http://www.hlxns.com'
    print(random.sample(pro, 1)[0])
    # html = requests.get(url, proxies={"https": http}, headers=headers)
    html = requests.get(url, proxies={"https": "http://" + random.sample(pro, 1)[0]},
                        headers=headers)
    html.encoding = 'utf-8'
    page = etree.HTML(html.text).xpath('//a[@class="item"]/text()')[-1]
    for i in range(int(line / 100) + 1, int(page) + 1):
        my_queue.put_nowait(i)
    for a in range(0, 20):
        threadD = threadDownload(my_queue)
        threadD.start()
    while my_queue.empty():
        break
