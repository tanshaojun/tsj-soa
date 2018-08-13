from selenium import webdriver
import time
from bs4 import BeautifulSoup
from lxml import *
import re


def logToFile(content, filename):
    f = open(filename, 'a', encoding='utf8')
    try:
        print(content)
        f.write(content + '\n')
    except:
        print('写入失败')
    finally:
        f.close()


# 登录QQ空间
def get_shuoshuo(qq):
    filename = qq + ".txt"
    print(filename)
    chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"
    driver = webdriver.Chrome(chromedriver)
    # 使用get()方法打开待抓取的URL
    # 抓取好友
    driver.get('http://user.qzone.qq.com/{}/311'.format(qq))
    # 抓取自己
    # driver.get('http://user.qzone.qq.com/{}/334'.format(qq))
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
        driver.find_element_by_link_text('留言板').click()
        time.sleep(3)
        driver.switch_to.frame('tgb')
        num = 1
        while (num < 641):
            num += 1
            pages = driver.page_source
            soup = BeautifulSoup(pages, 'lxml')
            aa = soup.find_all('span', attrs={'class': 'username'})
            louyanname = []
            for i in aa:
                aaaa = i.findAll('a')
                if aaaa != []:
                    for aaa in aaaa:
                        louyanname.append(aaa.getText())
                else:
                    louyanname.append("私密留言无法查看名字")
            louList = []
            liuyan = []
            shijian = []
            news_titles = soup.find_all(class_=re.compile('c_tx3 floor'))
            for i in news_titles:
                louList.append(i.getText())
            news_titles2 = soup.select("div.cont > table")
            for i in news_titles2:
                for tbody in i.findAll('tbody'):
                    for tr in tbody.findAll('tr'):
                        for td in tr.findAll('td'):
                            liuyan.append(td.getText())
            news_titles1 = soup.find_all(class_=re.compile('c_tx3 mode_post'))
            for i in news_titles1:
                a = i.getText()
                if a != "":
                    shijian.append(a)
            for i in range(len(louList)):
                data = {
                    '留言人': louyanname[i],
                    '几楼': louList[i],
                    '留言': liuyan[i],
                    '时间': shijian[i],
                }
                logToFile(str(data), str(filename))
            p = 'QZBlog.Util.PageIndexManager.goDirectPage(' + str(num) + ')'
            # driver.execute_script调用页面的js
            driver.execute_script(p + ';return false;')
    driver.close()
    driver.quit()


if __name__ == '__main__':
    get_shuoshuo('1041589452')
