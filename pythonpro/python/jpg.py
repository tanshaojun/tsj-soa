# python3.4 爬虫教程
# 爬取网站上的图片
# 林炳文Evankaka(博客：http://blog.csdn.net/evankaka/)
import urllib.request
import requests
import re

targetDir = "C:\图片"  # 文件保存路径

def download(url):
    response = requests.get(url)
    name = url.split('/')[-1]
    f = open(targetDir + '/' + name + '.jpg', 'wb')
    f.write(response.content)
    f.close()

if __name__ == "__main__":  # 程序运行入口
    webheaders = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'}
    for i in range(1, 50):
        weburl = "http://616pic.com/category?md=1&p=" + str(i)
        print("第" + str(i) + "页:" + weburl)
        req = urllib.request.Request(url=weburl, headers=webheaders)  # 构造请求报头
        webpage = urllib.request.urlopen(req)  # 发送请求报头
        contentBytes = webpage.read()
        for link, t in set(re.findall(r'(http:[^\s]*?(jpg|png|gif))', str(contentBytes))):  # 正则表达式查找所有的图片
            print(link)
            try:
                download(link)
            except:
                print('失败')  # 异常抛出
