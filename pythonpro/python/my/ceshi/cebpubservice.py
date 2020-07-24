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


filename = "C:/Users/lenovo/Desktop/data.xls"


def readline():
    wb = xlrd.open_workbook(filename, formatting_info=True)  # 打开excel，保留文件格式
    sheet1 = wb.sheet_by_index(0)  # 获取第一张表
    nrows = sheet1.nrows  # 获取总行数
    ncols = sheet1.ncols
    return nrows


def write(a, b, c, d, e, f):
    data = xlrd.open_workbook(filename)
    ws = xlutils.copy.copy(data)  # 复制之前表里存在的数据
    table = ws.get_sheet(0)
    nownrows = readline()
    table.write(nownrows, 0, label=a)  # 最后一行追加数据
    table.write(nownrows, 1, label=b)
    table.write(nownrows, 2, label=c)
    table.write(nownrows, 3, label=d)
    table.write(nownrows, 4, label=e)
    table.write(nownrows, 5, label=f)
    ws.save(filename)  # 保存的有旧数据和新数据


filters = ["征信", "二代征信", "担保", "融资", "信贷", "贷", "溯源", "溯源电商", "农产品溯源", "保理", "应收", "账款", "供应链金融"]


def cebpubservice():
    driver_chrome = ChromeDriverBrowser()
    driver_chrome.get("http://bulletin.cebpubservice.com/")
    iframe = driver_chrome.find_element_by_id("iframe")
    driver_chrome.switch_to.frame(iframe)
    count = 1
    while count < 500:
        try:
            print("当前第" + str(count) + "页")
            tds = driver_chrome.find_elements_by_xpath("//table[@class='table_text']/tbody/tr/td")
            size = 0
            while size < len(tds):
                name = tds[0 + size].text
                for f in filters:
                    if f in name:
                        print(name)
                        write(tds[0 + size].text, tds[1 + size].text, tds[2 + size].text,
                              tds[3 + size].text, tds[4 + size].text, tds[5 + size].text)
                        break
                size += 6
            driver_chrome.find_element_by_link_text("下一页").click()
        except Exception as e:
            print(str(count) + '报错: ', e)
        time.sleep(5)
        count += 1


if __name__ == '__main__':
    cebpubservice()
