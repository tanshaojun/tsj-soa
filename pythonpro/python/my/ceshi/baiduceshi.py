# -*- coding:utf-8 -*-
'''
从百度把前10页的搜索到的url爬取保存
'''
import multiprocessing   #利用pool进程池实现多进程并行
import time
from bs4 import BeautifulSoup    #处理抓到的页面
import sys
import requests
import importlib
importlib.reload(sys)#编码转换，python3默认utf-8,一般不用加
from urllib import request
import urllib

from selenium import webdriver
from selenium.webdriver.chrome.options import Options

from django.http import HttpResponse
import json
from django.views.decorators.csrf import csrf_exempt

chromedriver = r"/Users/penglili/Desktop/tools/chromedriver"
# 数据集合
l = []
hurong1 = 'hurongsoft.com'
hurong2 = 'zhongyunit.com'
hurong3 = '1zuyun.com'
hurong4 = 'blog.csdn.net'
hurong5 = 'www.cnblogs.com'
hurong6 = 'baike.baidu.com'
hurong8 = 'www.jianshu.com'
hurong9 = 'www.zhihu.com'
hurong10 = 'baijiahao.baidu.com'
hurong11 = 'www.zhihu.com'

headers = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Encoding': 'gzip, deflate, compress',
    'Accept-Language': 'en-us;q=0.5,en;q=0.3',
    'Cache-Control': 'max-age=0',
    'Connection': 'keep-alive',
    'User-Agent': 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:22.0) Gecko/20100101 Firefox/22.0'
} #定义头文件，伪装成浏览器

def ChromeDriverBrowser():
    chrome_options = Options()
    chrome_options.add_argument('--no-sandbox')  # 解决DevToolsActivePort文件不存在的报错
    chrome_options.add_argument('window-size=1920x1080')  # 指定浏览器分辨率
    driverChrome = webdriver.Chrome(executable_path=chromedriver, options=chrome_options)
    return driverChrome
# 无界面模式
def ChromeDriverNOBrowser():
    chrome_options = Options()
    chrome_options.add_argument('--no-sandbox')  # 解决DevToolsActivePort文件不存在的报错
    chrome_options.add_argument('window-size=1920x1080')  # 指定浏览器分辨率
    chrome_options.add_argument('--disable-gpu')  # 谷歌文档提到需要加上这个属性来规避bug
    chrome_options.add_argument('--hide-scrollbars')  # 隐藏滚动条, 应对一些特殊页面
    chrome_options.add_argument('--headless')  # 浏览器不提供可视化页面. linux下如果系统不支持可视化不加
    chrome_options.add_argument('--disable-dev-shm-usage')
    chrome_options.add_argument('blink-settings=imagesEnabled=false')
    driverChrome = webdriver.Chrome(executable_path=chromedriver, options=chrome_options)
    return driverChrome

def getfromBaidu(word):
    start = time.process_time()
    url = 'http://www.baidu.com.cn/s?wd=' + urllib.parse.quote(word) + '&pn='  # word为关键词，pn是百度用来分页的..
    pool = multiprocessing.Pool(multiprocessing.cpu_count())
    try:
        for k in range(1, 2):
            result = pool.apply_async(geturl, (url, k))# 多进程
    except Exception as e:
        print(e)
    finally:
        pool.close()
        pool.join()
        end = time.process_time()
        print('最后：')
        print(end-start)

def geturl(url, k):
    start = time.process_time()
    path = url + str((k - 1) * 10)
    driver = ChromeDriverBrowser()
    try:
        driver.implicitly_wait(15)
        driver.maximize_window()
        driver.get(url)
        ss = driver.find_elements_by_xpath("//h3[@class='t']/a[0]").click()
        print(ss)
        links = driver.find_elements_by_tag_name("a")
        print(links)
        for link in links:
            if not "_blank" in link.get_attribute("target") and ("google" in link.et_attribute("href") or not "http" in link.get_attribute("href")):
                link.click()
            return
        driver.back()
        print(ss)
        time.sleep(20)    #睡眠40s
    except Exception as e:
        print(e)
    finally:
        ##driver.refresh()    #刷新打开的页面
        ##driver.close()     #关闭浏览器
        ##driver.quit()
        end = time.process_time()
        print('过程：')
        print(end-start)

def getOpenUrl(url):
    start = time.process_time()
    driver = ChromeDriverBrowser()
    try:
        driver.implicitly_wait(15)
        driver.maximize_window()
        driver.get(url)
        time.sleep(40)    #睡眠40s
        driver.refresh()    #刷新打开的页面
    except Exception as e:
        print(e)
    finally:
        driver.close()     #关闭浏览器
        ##driver.quit()
        end = time.process_time()
        print('过程：')
        print(end-start)

if __name__ == '__main__':
    getfromBaidu('互融云')

@csrf_exempt
def getUrlBaidu(request):
    word = '互融云'
    getfromBaidu(word)
    return HttpResponse(json.dumps(l, ensure_ascii=False), content_type='application/json')