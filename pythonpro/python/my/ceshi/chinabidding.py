import time

import xlrd
import xlutils.copy
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"


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


filename = "C:/Users/lenovo/Desktop/data/data.xls"


def readline():
    wb = xlrd.open_workbook(filename, formatting_info=True)  # 打开excel，保留文件格式
    sheet1 = wb.sheet_by_index(0)  # 获取第一张表
    nrows = sheet1.nrows  # 获取总行数
    ncols = sheet1.ncols
    return nrows


def write(a, b, c):
    data = xlrd.open_workbook(filename)
    ws = xlutils.copy.copy(data)  # 复制之前表里存在的数据
    table = ws.get_sheet(0)
    nownrows = readline()
    table.write(nownrows, 0, label=a)  # 最后一行追加数据
    table.write(nownrows, 1, label=b)
    table.write(nownrows, 2, label=c)
    ws.save(filename)  # 保存的有旧数据和新数据


# def chinabidding():
#     try:
#         driver_chrome = ChromeDriverBrowser()
#         driver_chrome.get("https://www.chinabidding.cn/cblcn/member.login/login")
#         driver_chrome.find_element_by_id('name').clear()
#         driver_chrome.find_element_by_id("name").send_keys("hurongyun")
#         time.sleep(2)
#         driver_chrome.find_element_by_id('pwd11').clear()
#         js = "document.getElementById(\"pwd11\").style.display='block';"
#         # 调用js脚本
#         driver_chrome.execute_script(js)
#         time.sleep(2)
#         driver_chrome.find_element_by_id("pwd11").send_keys("test")
#         time.sleep(2)
#         driver_chrome.find_element_by_id("password").send_keys("hurongyun888")
#         time.sleep(2)
#         print("请输入控制台验证码：")
#         code = input()
#         print("控制台输入验证码为：" + code)
#         driver_chrome.find_element_by_id('yzm').clear()
#         driver_chrome.find_element_by_id('yzm').send_keys(code)
#         driver_chrome.find_element_by_class_name('deng').click()
#         time.sleep(2)
#         driver_chrome.find_element_by_xpath("//ul[@class='nav_t']/li/a[2]").click()
#         time.sleep(2)
#         driver_chrome.switch_to.window(driver_chrome.window_handles[1])
#         driver_chrome.maximize_window()
#         time.sleep(2)
#         size = 2
#         while size < 2:
#             trs = driver_chrome.find_elements_by_xpath("//tr[@class='yj_nei']")
#             for tr in trs:
#                 tds = tr.find_elements_by_xpath("./td")
#                 name = tds[0].find_element_by_xpath("./a").text
#                 date = tds[3].text
#                 type = tds[1].text
#                 for f in filters:
#                     if f in name:
#                         print(name)
#                         write(name, type, date)
#             driver_chrome.execute_script("javascript:pageJump(" + str(size) + ")")
#             time.sleep(2)
#             print("当前第" + str(size) + "页")
#             size += 1
#     except Exception as e:
#         print(e)
#         print('报错: ', e)
#     print("完成...........")


filters = ["征信", "二代征信", "担保", "融资", "信贷", "贷", "溯源", "溯源电商", "农产品溯源", "保理", "应收", "账款", "供应链金融", "区块链", "碳排放", "大宗商品", "电商小程序", "分期", "电商金融", "金融", "社交", "防伪", "追溯", "一物一码", "防窜货", "融资租赁", "贷款", "保理", "典当", "风控", "催收"]


def chinabidding():
    try:
        driver_chrome = ChromeDriverBrowser()
        driver_chrome.get("https://www.chinabidding.cn/cblcn/member.login/login")
        driver_chrome.find_element_by_id('name').clear()
        driver_chrome.find_element_by_id("name").send_keys("hurongyun")
        time.sleep(2)
        driver_chrome.find_element_by_id('pwd11').clear()
        js = "document.getElementById(\"pwd11\").style.display='block';"
        # 调用js脚本
        driver_chrome.execute_script(js)
        time.sleep(2)
        driver_chrome.find_element_by_id("pwd11").send_keys("test")
        time.sleep(2)
        driver_chrome.find_element_by_id("password").send_keys("hurongyun888")
        time.sleep(2)
        print("请输入控制台验证码：")
        code = input()
        print("控制台输入验证码为：" + code)
        driver_chrome.find_element_by_id('yzm').clear()
        driver_chrome.find_element_by_id('yzm').send_keys(code)
        driver_chrome.find_element_by_class_name('deng').click()
        time.sleep(2)
        driver_chrome.find_element_by_xpath("//ul[@class='nav_t']/li/a[2]").click()
        time.sleep(2)
        driver_chrome.maximize_window()
        for filter in filters:
            driver_chrome.switch_to.window(driver_chrome.window_handles[1])
            time.sleep(2)
            driver_chrome.find_element_by_class_name("wenben").clear()
            driver_chrome.find_element_by_class_name("wenben").send_keys(filter)
            time.sleep(2)
            driver_chrome.find_elements_by_xpath("//input[@class='sous fl']")[0].click()
            save_data(driver_chrome, filter)
            driver_chrome.close()
    except Exception as e:
        print('报错: ', e)
    print("完成...........")


def save_data(driver_chrome, keyword):
    driver_chrome.switch_to.window(driver_chrome.window_handles[2])
    size = 1
    flag = True
    while flag:
        print("关键字为：" + keyword + ",当前第" + str(size) + "页")
        trs = driver_chrome.find_elements_by_xpath("//tr[@class='listrow1']")
        for tr in trs:
            tds = tr.find_elements_by_xpath("./td")
            type = tds[3].text
            if "招标公告" in type:
                td1 = tds[1].find_element_by_xpath("./a")
                name = td1.text
                url = td1.get_attribute("href")
                date = tds[6].text
                write(name, date, url)
        trs2 = driver_chrome.find_elements_by_xpath("//tr[@class='listrow2']")
        for tr in trs2:
            tds = tr.find_elements_by_xpath("./td")
            type = tds[3].text
            if "招标公告" in type:
                td1 = tds[1].find_element_by_xpath("./a")
                name = td1.text
                url = td1.get_attribute("href")
                date = tds[6].text
                write(name, date, url)
        if len(trs) == 0 and len(trs2) == 0:
            flag = False
        else:
            size += 1
            driver_chrome.execute_script("javascript:pageJump(" + str(size) + ")")


if __name__ == '__main__':
    chinabidding()
