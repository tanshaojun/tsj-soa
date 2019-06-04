from PIL import Image, ImageEnhance
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


url = 'https://www.zhongdengwang.org.cn/rs/main.do'

# driver = webdriver.Chrome(chromedriver)
driver = ChromeDriverBrowser()
driver.implicitly_wait(10)
driver.maximize_window()
driver.get(url)
driver.find_element_by_link_text('登录').click()
driver.switch_to.frame(driver.find_elements_by_tag_name("iframe")[0])
try:
    driver.find_element_by_id('login_btn')
    isLogin = True
except:
    isLogin = False
if isLogin:
    driver.save_screenshot("C:\\Users\\lenovo\\Desktop\\01.png")
    ran = Image.open("C:\\Users\\lenovo\\Desktop\\01.png")
    box = (1388, 480, 1491, 515)  # 左，上，右，下
    # box = (1310, 386, 1392, 413)  # 左，上，右，下
    ran.crop(box).save("C:\\Users\\lenovo\\Desktop\\01.png")
    # 4、获取验证码图片，读取验证码
    imageCode = Image.open("C:\\Users\\lenovo\\Desktop\\01.png")  # 图像增强，二值化
    # imageCode.load()
    sharp_img = ImageEnhance.Contrast(imageCode).enhance(2.0)
    sharp_img.save("C:\\Users\\lenovo\\Desktop\\01.png")
    sharp_img.load()  # 对比度增强
    # code = pytesseract.image_to_string(sharp_img).strip()
    # print(code)

    driver.find_element_by_id('userCode').clear()
    driver.find_element_by_id('userCode').send_keys('tanshaojun')
    # 调用js脚本
    js = "document.getElementById(\"password\").style.display='block';"
    driver.execute_script(js)
    driver.find_element_by_id('password').clear()
    driver.find_element_by_id('password').send_keys('tan123456')
    # # 需要验证码
    print("请输入控制台验证码：" )
    code = input()
    print("控制台输入验证码为：" + code)
    driver.find_element_by_id('validateCode').clear()
    driver.find_element_by_id('validateCode').send_keys(code)
    driver.find_element_by_id('login_btn').click()
    driver.find_element_by_id('send').click()
    # 需要手机验证码
    print("请输入手机验证码：" )
    code = input()
    print("控制台输入手机验证码为：" + code)
    driver.find_element_by_id('sms').clear()
    driver.find_element_by_id('sms').send_keys(code)
    driver.find_element_by_id('login_btn').click()
    # cookiesAfter = driver.get_cookies()
    driver.find_element_by_link_text('按主体查询').click()
    driver.find_element_by_link_text('按担保人名称查询').click()

    driver.save_screenshot("C:\\Users\\lenovo\\Desktop\\02.png")
    ran = Image.open("C:\\Users\\lenovo\\Desktop\\02.png")
    box = (973, 325, 1092, 366)  # 左，上，右，下
    ran.crop(box).save("C:\\Users\\lenovo\\Desktop\\02.png")
    # 4、获取验证码图片，读取验证码
    imageCode = Image.open("C:\\Users\\lenovo\\Desktop\\02.png")  # 图像增强，二值化
    # imageCode.load()
    sharp_img = ImageEnhance.Contrast(imageCode).enhance(2.0)
    sharp_img.save("C:\\Users\\lenovo\\Desktop\\02.png")
    sharp_img.load()  # 对比度增强
    # code = pytesseract.image_to_string(sharp_img).strip()
    # print(code)

    driver.find_element_by_id('name').clear()
    driver.find_element_by_id('name').send_keys('陕西万泰邦建设工程有限公司')
    print("请输入控制台验证码：" )
    code = input()
    print("控制台输入验证码为：" + code)
    driver.find_element_by_id('validateCode').clear()
    driver.find_element_by_id('validateCode').send_keys(code)
    # # 需要输入验证码
    driver.find_element_by_id('query').click()
    driver.find_element_by_link_text('查看应收账款质押和转让登记').click()

    js = "var q=document.documentElement.scrollTop=100000"
    driver.execute_script(js)
    driver.save_screenshot("C:\\Users\\lenovo\\Desktop\\03.png")
    ran = Image.open("C:\\Users\\lenovo\\Desktop\\03.png")
    box = (714, 629, 899, 679)  # 左，上，右，下
    ran.crop(box).save("C:\\Users\\lenovo\\Desktop\\04.png")
    # 4、获取验证码图片，读取验证码
    imageCode = Image.open("C:\\Users\\lenovo\\Desktop\\04.png")  # 图像增强，二值化
    # imageCode.load()
    sharp_img = ImageEnhance.Contrast(imageCode).enhance(2.0)
    sharp_img.save("C:\\Users\\lenovo\\Desktop\\04.png")
    sharp_img.load()  # 对比度增强
    print("请输入控制台验证码：" )
    code = input()
    print("控制台输入验证码为：" + code)
    driver.find_element_by_name("validateCode").send_keys(code)
    driver.find_element_by_css_selector('.boxyx span').click()
    print("完成")
