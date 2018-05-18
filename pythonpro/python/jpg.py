#python3.4 爬虫教程
#爬取网站上的图片
#林炳文Evankaka(博客：http://blog.csdn.net/evankaka/)
import urllib.request
import re
import os
targetDir = "C:\tansj\jpg"  #文件保存路径
def destFile(path):
    if not os.path.isdir(targetDir):
        os.mkdir(targetDir)
    pos = path.rindex('/')
    t = os.path.join(targetDir, path[pos+1:])
    return t


def save_img(img_url,filename,file_path='C:\jsp'):
    #保存图片到磁盘文件夹 file_path中，默认为当前脚本运行目录下的 book\img文件夹
    try:
        if not os.path.exists(file_path):
            print ('文件夹',file_path,'不存在，重新建立')
            #os.mkdir(file_path)
            os.makedirs(file_path)
        #获得图片后缀
        file_suffix = os.path.splitext(img_url)[1]
        #拼接图片名（包含路径）
        # filename = '{}{}{}{}'.format(file_path,os.sep,file_name,file_suffix)
        #下载图片，并保存到文件夹中
        urllib.request.urlretrieve(img_url,filename=filename)
    except IOError as e:
        print ('文件操作失败',e)
    except Exception as e:
        print ('错误 ：',e)


if __name__ == '__main__':  #程序运行入口
    weburl ="https://www.baidu.com/"
    webheaders = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0'}
    req = urllib.request.Request(url=weburl, headers=webheaders)  #构造请求报头
    webpage = urllib.request.urlopen(req)  #发送请求报头
    contentBytes = webpage.read()
    contentBytes=contentBytes.decode('utf-8')
    print(contentBytes)
    for link, t in set(re.findall(r'(http:[^s]*?(jpg|png|gif))', str(contentBytes))):  #正则表达式查找所有的图片
        print(link)
        try:
            # urllib.request.urlretrieve(link, destFile(link)) #下载图片
            save_img(link,"test")
        except:
            print('失败') #异常抛出