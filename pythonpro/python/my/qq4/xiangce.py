#!coding:utf-8
from selenium import webdriver
import requests, time, json
from bs4 import BeautifulSoup
from lxml import *
import re
import random

folder = "C:\图片"  # 文件保存路径


def download(url):
    response = requests.get(url)
    f = open(folder + '/' + str(random.randint(1000000000, 999999999999)) + '.jpg', 'wb')
    f.write(response.content)
    f.close()


# 登录QQ空间
def get_xiangche(qq):
    chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
    driver = webdriver.Chrome(chromedriver)
    # 使用get()方法打开待抓取的URL
    # 抓取好友
    # driver.get('http://user.qzone.qq.com/{}/311'.format(qq))
    # 抓取自己
    # driver.get('http://user.qzone.qq.com/{}/334'.format(qq))
    # 抓自己相册
    driver.get('https://user.qzone.qq.com/{}/4'.format(qq))
    time.sleep(5)
    # 等待5秒后，判断页面是否需要登录，通过查找页面是否有相应的DIV的id来判断
    try:
        driver.find_element_by_id('login_div')
        a = True
    except:
        a = False
    if a == True:
        # 如果页面存在登录的DIV，则模拟登录
        driver.switch_to.frame('login_frame')
        driver.find_element_by_id('switcher_plogin').click()
        driver.find_element_by_id('u').clear()  # 选择用户名框
        driver.find_element_by_id('u').send_keys('877513390')
        driver.find_element_by_id('p').clear()
        driver.find_element_by_id('p').send_keys('123456')
        driver.find_element_by_id('login_button').click()
        time.sleep(10)
    driver.implicitly_wait(10)

    # 判断好友空间是否设置了权限，通过判断是否存在元素ID：QM_OwnerInfo_Icon
    try:
        driver.find_element_by_id('QM_OwnerInfo_Icon')
        b = True
    except:
        b = False
    if b:
        driver.switch_to.frame('app_canvas_frame')
        pages = driver.page_source
        soup = BeautifulSoup(pages, 'lxml')
        time.sleep(3)
        news_titles = soup.find_all(class_=re.compile('c-tx2 js-album-desc-a'))
        time.sleep(3)
        driver.find_element_by_link_text(str(news_titles[3].getText())).click()
        pages1 = driver.page_source
        soup1 = BeautifulSoup(pages1, 'lxml')
        time.sleep(3)
        news_titles1 = soup1.find_all(class_=re.compile('j-pl-photoitem-img'))
        for j in news_titles1:
            jj = j.get("src")
            if jj:
                download(jj)


if __name__ == '__main__':
    get_xiangche('877513390')
