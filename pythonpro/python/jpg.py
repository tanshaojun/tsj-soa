#python3.4 爬虫教程
#爬取网站上的图片
#林炳文Evankaka(博客：http://blog.csdn.net/evankaka/)
import urllib.request
import re
import os
targetDir = "C:\图片"  #文件保存路径
def destFile(path):
    if not os.path.isdir(targetDir):
        os.mkdir(targetDir)
    pos = path.rindex('/')
    t = os.path.join(targetDir, path[pos+1:])
    return t
if __name__ == "__main__":  #程序运行入口
    weburl = "http://616pic.com/png/?sem=7&sem_kid=27&ks=4940"
    webheaders = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'}
    req = urllib.request.Request(url=weburl, headers=webheaders)  #构造请求报头
    webpage = urllib.request.urlopen(req)  #发送请求报头
    contentBytes = webpage.read()
    for link, t in set(re.findall(r'(http:[^\s]*?(jpg|png|gif))', str(contentBytes))):  #正则表达式查找所有的图片
        print(link)
        try:
            urllib.request.urlretrieve(link, destFile(link)) #下载图片
        except:
            print('失败') #异常抛出