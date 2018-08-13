import requests, time, json
from bs4 import BeautifulSoup
from lxml import *
import re
import random
from selenium import webdriver

folder = "C:\图片"  # 文件保存路径


def download(url):
    response = requests.get(url)
    f = open(folder + '/' + str(random.randint(1000000000, 999999999999)) + '.jpg', 'wb')
    f.write(response.content)
    f.close()


# 登录知乎
def get_zf():
    chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
    driver = webdriver.Chrome(chromedriver)
    # 使用get()方法打开待抓取的URL
    # driver.get('https://www.zhihu.com/people/kaifulee/followers?page=1')
    # 如果页面存在登录的DIV，则模拟登录
    # driver.find_element_by_name('username').clear()  # 选择用户名框
    # driver.find_element_by_name('username').send_keys('17600904801')
    # driver.find_element_by_name('password').clear()
    # driver.find_element_by_name('password').send_keys('123465')
    # driver.find_element_by_link_text('登录').click()
    # time.sleep(10)
    # driver.implicitly_wait(10)
    # pages = driver.page_source
    # soup = BeautifulSoup(pages, 'lxml')
    # numbei_s = soup.find_all(class_=re.compile('NumberBoard-itemValue'))
    # 点击
    # numbei_s_click = soup.find_all(class_=re.compile('NumberBoard-itemName'))
    # 我关注了
    # follow = numbei_s[1].getText()
    # 我被关注了
    # coverfollow = numbei_s[1].getText()
    num = 0
    # if follow:
    while (num < 52615):
        num += 1
        driver.get('https://www.zhihu.com/people/kaifulee/followers?page=' + str(num))

        pages = driver.page_source
        soup = BeautifulSoup(pages, 'lxml')
        # numbei_s = soup.find_all(class_=re.compile('NumberBoard-itemValue'))
        user_date = soup.find_all(class_=re.compile('UserLink-link'))

        for user in user_date:
            aaaa = user.findAll('img')
            if aaaa:
                img_url = aaaa[0].get("src")
                if img_url != "https://pic4.zhimg.com/da8e974dc_im.jpg":
                    download(img_url)


if __name__ == '__main__':
    get_zf()
