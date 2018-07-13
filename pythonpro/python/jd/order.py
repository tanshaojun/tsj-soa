from selenium import webdriver
import time
from bs4 import BeautifulSoup
from lxml import *
import re

driver = webdriver.Chrome(r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe")
driver.get(
    "https://passport.jd.com/new/login.aspx?ReturnUrl=https%3A%2F%2Fwww.jd.com%2F%3Fcu%3Dtrue%26utm_source%3Dbaidu-pinzhuan%26utm_medium%3Dcpc%26utm_campaign%3Dt_288551095_baidupinzhuan%26utm_term%3D0f3d30c8dba7459bb52f2eb5eba8ac7d_0_0df3b31aed3f4045867813044f48d802")
driver.find_element_by_link_text("账户登录").click()
driver.find_element_by_id("loginname").send_keys("132465")
time.sleep(2)
driver.find_element_by_id("nloginpwd").send_keys("123465")
time.sleep(2)
driver.find_element_by_id("loginsubmit").click()
time.sleep(2)
driver.find_element_by_link_text("我的订单").click()
driver.get('https://order.jd.com/center/list.action')
pages = driver.page_source
soup = BeautifulSoup(pages, 'lxml')
user_date = soup.select('table > tbody')
print(user_date)
