import time

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


def qixin():
    verification = ["无", "无", "无", "无", "无", "无", "无", "无", "无", "无"]
    driver_chrome = ChromeDriverBrowser()
    driver_chrome.get(
        "https://www.qixin.com/auth/login?return_url=%2Fsearch%3Fkey%3D%25E8%25B4%25B7%25E6%25AC%25BE%26page%3D3")
    driver_chrome.find_element_by_xpath("//input[@class='form-control input-lg input-flat number-input']").clear()
    driver_chrome.find_element_by_xpath("//input[@class='form-control input-lg input-flat number-input']").send_keys(
        "13263308067")
    driver_chrome.find_element_by_xpath("//input[@class='form-control input-lg input-flat']").clear()
    driver_chrome.find_element_by_xpath("//input[@class='form-control input-lg input-flat']").send_keys("hurongyun0421")
    driver_chrome.find_element_by_xpath("//div[@class='btn btn-primary btn-block btn-lg']").click()
    print("等待手动验证中.........")
    time.sleep(20)
    driver_chrome.find_element_by_xpath("//input[@class='form-control input tt-input']").clear()
    driver_chrome.find_element_by_xpath("//input[@class='form-control input tt-input']").send_keys("征信")
    driver_chrome.find_element_by_xpath("//span[@class='inline-content font-16']").click()
    page = 1
    flag = True
    while flag:
        try:
            divs = driver_chrome.find_elements_by_xpath(
                "//div[@class='col-xs-24 padding-v-25px margin-0-0x border-b-b4 company-item']")
            idx = 0
            for div in divs:
                a = div.find_element_by_xpath("./div[@class='col-2 clearfix']/div[@class='col-2-1']/div[1]/a")
                company = a.text
                print(company)
                if verification[idx] == company:
                    flag = False
                verification[idx] = company
                idx += 1
            page += 1
            driver_chrome.find_element_by_xpath("//input[@class='form-control input-sm']").clear()
            driver_chrome.find_element_by_xpath("//input[@class='form-control input-sm']").send_keys(page)
            driver_chrome.find_element_by_xpath("//button[@class='btn btn-primary btn-sm']").click()
            time.sleep(2)
        except Exception as e:
            print("页面手动验证之后请输入：")
            code = input()
            flag = True
            print(code)

    print("完成...........")

if __name__ == '__main__':
    qixin()
