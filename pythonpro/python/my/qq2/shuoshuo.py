# -*- coding:utf-8 -*-
from bs4 import BeautifulSoup
from selenium import webdriver
import time

# 登录QQ空间
def get_shuoshuo(qq):
    chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
    driver = webdriver.Chrome(chromedriver)
    # 使用get()方法打开待抓取的URL
    driver.get('http://user.qzone.qq.com/{}/311'.format(qq))
    # driver.get(' http://1518945900.qzone.qq.com/?uin=1518945900&url=http://imgcache.qq.com/qzone/blog/tmygb_static.htm')
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
        driver.find_element_by_id('u').send_keys('1572214237')
        driver.find_element_by_id('p').clear()
        driver.find_element_by_id('p').send_keys('chao2018')
        driver.find_element_by_id('login_button').click()
        time.sleep(3)
    driver.implicitly_wait(3)

    # 判断好友空间是否设置了权限，通过判断是否存在元素ID：QM_OwnerInfo_Icon
    try:
        driver.find_element_by_id('QM_OwnerInfo_Icon')
        b = True
    except:
        b = False
    # 如果有权限能够访问到说说页面，那么定位元素和数据，并解析
    if b:
        driver.switch_to.frame('app_canvas_frame')
        content = driver.find_elements_by_css_selector('.content')
        stime = driver.find_elements_by_css_selector('.c_tx.c_tx3.goDetail')
        for con, sti in zip(content, stime):
            data = {
                'time': sti.text,
                'shuos': con.text
            }
            print(data)
        pages = driver.page_source
        soup = BeautifulSoup(pages, 'lxml')

    # 尝试一下获取Cookie，使用get_cookies()
    cookie = driver.get_cookies()
    cookie_dict = []
    for c in cookie:
        ck = "{0}={1};".format(c['name'], c['value'])
        cookie_dict.append(ck)
    i = ''
    for c in cookie_dict:
        i += c
    print('Cookies:', i)
    print("==========完成================")

    driver.close()
    driver.quit()


if __name__ == '__main__':
    get_shuoshuo('1041589452')
