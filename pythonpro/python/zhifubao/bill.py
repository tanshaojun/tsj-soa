from selenium import webdriver
import time

N = 1
F_Login = 0


def keep_safe(driver):
    try:
        F = 1
        while (F):
            if F_Login == 1:
                QR_Code = driver.find_element_by_xpath('//*[@id="container"]/h2').text
                txt = '安全校验'
            else:
                QR_Code = driver.find_element_by_xpath('/html/body/div/div[1]/div/h1/a[2]').text  # 1
                txt = '登录'
            if QR_Code == txt:
                print(txt)
                print('请在15s内扫码')
                if txt == '安全校验':
                    time.sleep(15)
                    QR_Code_2 = driver.find_element_by_xpath('//*[@id="container"]/h2').text
                    if QR_Code_2 == QR_Code:
                        F = 1
                    else:
                        F = 0
                elif txt == '登录':
                    time.sleep(15)
                    QR_Code_2 = QR_Code = driver.find_element_by_xpath('/html/body/div/div[1]/div/h1/a[2]').text
                    if QR_Code_2 == QR_Code:
                        F = 1
                    else:
                        F = 0
    except:
        pass


def getInfor(driver):
    global N
    for num in range(10):
        num = num + 1
        al_day_xpath = '//*[@id="J-item-' + str(num) + '"]/td[2]/p[1]'  # //*[@id="J-item-1"]/td[2]/p[1]    日期
        al_time_xpath = '//*[@id="J-item-' + str(num) + '"]/td[2]/p[2]'  # //*[@id="J-item-1"]/td[2]/p[2]    时刻
        al_way_xpath = '//*[@id="J-item-' + str(num) + '"]/td[3]/p[1]'  # //*[@id="J-item-1"]/td[3]/p[1]  方式
        al_payee_xpath = '//*[@id="J-item-' + str(num) + '"]/td[3]/p[2]'  # //*[@id="J-item-1"]/td[3]/p[2]/span 收款人
        al_snum_xpath = '//*[@id="J-tradeNo-' + str(num) + '"]'  # //*[@id="J-tradeNo-1"] 号#.get_attribute("title")
        al_figure_xpath = '//*[@id="J-item-' + str(num) + '"]/td[4]/span'  # //*[@id="J-item-1"]/td[4]/span 金额
        al_status_xpath = '//*[@id="J-item-' + str(num) + '"]/td[6]/p[1]'  # //*[@id="J-item-1"]/td[6]/p[1] 交易状态

        al_day = driver.find_element_by_xpath(al_day_xpath).text
        al_time = driver.find_element_by_xpath(al_time_xpath).text
        al_way = driver.find_element_by_xpath(al_way_xpath).text
        al_payee = driver.find_element_by_xpath(al_payee_xpath).text
        al_snum = driver.find_element_by_xpath(al_snum_xpath).get_attribute("title")
        al_figure = driver.find_element_by_xpath(al_figure_xpath).text
        al_status = driver.find_element_by_xpath(al_status_xpath).text
        print(str(
            N) + '.' + '日期' + ':' + al_day + '\t时间' + ':' + al_time + '\t方式' + ':' + al_way + '\t收款人' + ':' + al_payee + '\t流水号' + ':' + al_snum + '\t金额' + ':' + al_figure + '\t交易状态' + ':' + al_status)
        N = N + 1


driver = webdriver.Chrome(r"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe")
driver.get(
    "https://auth.alipay.com/login/index.htm?goto=https%3A%2F%2Fmy.alipay.com%2Fportal%2Fi.htm%3Freferer%3Dhttps%253A%252F%252Fauthet15.alipay.com%252Flogin%252FhomeB.htm")
driver.find_element_by_xpath('//*[@id="J-loginMethod-tabs"]/li[2]').click()

ali_num = '' # 账号密码
ali_pad = ''# 密码
driver.find_element_by_xpath('//*[@id="J-input-user"]').clear()
time.sleep(3)
for i in ali_num:
    driver.find_element_by_xpath('//*[@id="J-input-user"]').send_keys(i)
    time.sleep(0.5)
driver.find_element_by_xpath('//*[@id="password_rsainput"]').clear()
driver.find_element_by_xpath('//*[@id="password_rsainput"]').click()
for i in ali_pad:
    driver.find_element_by_xpath('//*[@id="password_rsainput"]').send_keys(i)
    time.sleep(0.5)
time.sleep(10)
driver.find_element_by_xpath('//*[@id="password_rsainput"]').text
driver.find_element_by_xpath('//*[@id="J-login-btn"]').click()

time.sleep(3)
keep_safe(driver)
F_Login = 1
driver.get('https://consumeprod.alipay.com/record/standard.htm')
time.sleep(2)
keep_safe(driver)
cnt = 0

for i in range(8):
    if cnt == 1:
        elem = driver.find_element_by_xpath('//*[@id="J_home-record-container"]/div[2]/div/div[2]/div[2]/div/a[1]')
        cnt = cnt + 1
        elem.click()
    elif cnt == 0:
        cnt = cnt + 1
    else:
        elem = driver.find_element_by_xpath('//*[@id="J_home-record-container"]/div[2]/div/div[2]/div[2]/div/a[3]')
        elem.click()
    time.sleep(2)
    keep_safe(driver)
    try:
        getInfor(driver)
    except:
        print('估计是没了！')
        pass
