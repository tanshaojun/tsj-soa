from selenium import webdriver
import time
from bs4 import BeautifulSoup
from lxml import *


def logToFile(content):
    f = open('liu.txt', 'a', encoding='utf8')
    try:
        print(content)
        f.write(content + '\n')
    except:
        print('Exception:')
    finally:
        f.close()

# 登录QQ空间
def get_shuoshuo(qq):
    chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
    driver = webdriver.Chrome(chromedriver)
    # 使用get()方法打开待抓取的URL
    driver.get('http://user.qzone.qq.com/{}/311'.format(qq))
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
        driver.find_element_by_id('u').send_keys('240329667')
        driver.find_element_by_id('p').clear()
        driver.find_element_by_id('p').send_keys('xuan2010518**')
        driver.find_element_by_id('login_button').click()
        time.sleep(3)
    driver.implicitly_wait(3)

    # 判断好友空间是否设置了权限，通过判断是否存在元素ID：QM_OwnerInfo_Icon
    try:
        driver.find_element_by_id('QM_OwnerInfo_Icon')
        b = True
    except:
        b = False
    if b == True:
        driver.find_element_by_link_text('留言板').click()
        driver.implicitly_wait(3)
        time.sleep(5)
        # driver.switch_to_frame('tgb')
        driver.switch_to.frame('tgb')
        num = 1
        while (num < 5):
            num += 1
            time.sleep(2)

            memu = driver.find_element_by_id('ulCommentList')
            logToFile(memu.text)
            # pages = driver.page_source
            # soup = BeautifulSoup(pages, 'lxml')
            # elector=pages.HTML(soup)  #将源码转化为能被XPath匹配的格式
            # count=elector.xpath('//div[@id="ulCommentList"]/ul/li/text()')
            # print(count)
            p = 'QZBlog.Util.PageIndexManager.goDirectPage(' + str(num) + ')'
            # driver.execute_script调用页面的js
            driver.execute_script(p + ';return false;')
        # driver.close()
        # driver.quit()

if __name__ == '__main__':
    get_shuoshuo('1518945900')
