from selenium import webdriver
from selenium.webdriver.chrome.options import Options

chromedriver = r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe"


# 无界面模式
def ChromeDriverNOBrowser():
    chrome_options = Options()
    chrome_options.add_argument('--no-sandbox')  # 解决DevToolsActivePort文件不存在的报错
    chrome_options.add_argument('window-size=1920x1080')  # 指定浏览器分辨率
    chrome_options.add_argument('--disable-gpu')  # 谷歌文档提到需要加上这个属性来规避bug
    chrome_options.add_argument('--hide-scrollbars')  # 隐藏滚动条, 应对一些特殊页面
    chrome_options.add_argument('--headless')  # 浏览器不提供可视化页面. linux下如果系统不支持可视化不加
    driverChrome = webdriver.Chrome(executable_path=chromedriver, chrome_options=chrome_options)
    return driverChrome


def ChromeDriverBrowser():
    chrome_options = Options()
    # prefs = {'profile.default_content_settings.popups': 0, 'download.default_directory': 'd:\\'}
    # chrome_options.add_experimental_option('prefs', prefs)
    chrome_options.add_argument('--no-sandbox')  # 解决DevToolsActivePort文件不存在的报错
    chrome_options.add_argument('window-size=1920x1080')  # 指定浏览器分辨率
    driverChrome = webdriver.Chrome(executable_path=chromedriver, chrome_options=chrome_options)
    return driverChrome


url = 'http://www.baidu.com.cn/s?wd=区块链技术&pn='

# driver = webdriver.Chrome(chromedriver)
driver = ChromeDriverBrowser()
driver.implicitly_wait(10)
driver.maximize_window()
driver.get(url)
driver.find_element_by_id('su').click()
r = driver.find_element_by_xpath("//div[@id='3001']")
print(r.text)
r2 = driver.find_element_by_xpath("//div[@id='3002']")
print(r2.text)
r3 = driver.find_element_by_xpath("//div[@id='3003']")
print(r3.text)
r4 = driver.find_element_by_xpath("//div[@id='3004']")
print(r4.text)
r5 = driver.find_element_by_xpath("//div[@id='3005']")
print(r5.text)
r6 = driver.find_element_by_xpath("//div[@id='3006']")
print(r6.text)
# js = "document.getElementById(\"3001\").style.display='block';"
# driver.execute_script(js)

