from urllib import parse
from selenium import webdriver
import requests
import json
from json import loads
import time
# import pymssql
import datetime

def get_key_values(body,key,end =';'):
    """提取body中不包括的key，分片操作

    :param body: 父字符串
    :param key: 子字符串
    :param end: 结束字符串，默认为;
    :return: 不包括子字符串的字符串
    """
    return body[body.find(key) + len(key): body.find(';', body.find(key))]

def get_key(cookies):
    """获取cookie中的相关键的值
    解密

    :param cookies: 缓存
    :return: 相关键的值
    """
    key = get_key_values(cookies,'p_skey=')
    h = 5381
    for i in key:
        h += (h << 5) + ord(i)
    return h & 2147483647

def web_login_cookie():
    """url = 'https://user.qzone.qq.com/QQ号相关的缓存
    实现自动化登录

    :return: 浏览器的缓存
    """
    driver = webdriver.Chrome()
    qq_account = '767650993'
    qq_password = 'love000000'
    login(driver,qq_account,qq_password)
    time.sleep(10)
    driver.get('https://user.qzone.qq.com/{}'.format(qq_account))
    cookie = ''
    for elem in driver.get_cookies(): # 记录相关的Cookie
        # elem 为 dict类型
        cookie += elem["name"] + "=" + elem["value"] + ";"
    # cookies = cookie
    return cookie

def login(driver,qq_account,qq_password):
    """登录

    :param driver: 浏览器对象
    :param qq_account: QQ账号
    :param qq_password: QQ密码
    :return:
    """
    driver.maximize_window()
    driver.get('http://user.qzone.qq.com')
    driver.switch_to.frame('login_frame')
    time.sleep(1)
    driver.find_element_by_id("switcher_plogin").click()
    driver.find_element_by_id("u").send_keys(qq_account)
    time.sleep(2)
    driver.find_element_by_id("p").send_keys(qq_password)
    time.sleep(2)
    driver.find_element_by_id("login_button").click()

def send_requests(req,headers,url,params=None):
    """url_friend = 'https://user.qzone.qq.com/proxy/domain/r.qzone.qq.com/cgi-bin/tfriend/friend_ship_manager.cgi?'
    url_friend携带以下参数：uin（QQ号）、do（没有它，返回空，默认值为：1）
    rd，g_t，qzonetoken（每次登录都发生变化，从Cookiezz中获取）
    fupdate，clean（默认值为：1）

    :param req: 请求（Request）,该请求为会话
    :param headers: 请求头
    :param params: 请求参数
    :return: JSONP数据
    """
    if None != params:
        url = url + parse.urlencode(params)
    # url = url+'&offset='+str(0)
    page = req.get(url=url, headers=headers)
    return page.text

def get_each_str(req,uin,headers):
    each_url = 'https://user.qzone.qq.com/{}'.format(uin)
    page = req.get(url=each_url, headers=headers)

# def friend_db(dicts,name=''):
#     """操作DB
#
#     :param dicts: 数据字典信息
#     :param name: 备注名
#     :return: void
#     """
#     if len(str(dicts['birthyear'])) < 4:
#         dicts['birthyear'] = '1900'
#     if dicts['birthday'][1:2] == '0':
#         dicts['birthday'] = '01-01'
#     if len(dicts['signature']) > 70:
#         dicts['signature'] = ''
#     friend_db_dict = {
#         'friendInfo': [
#             dicts['uin'], name, dicts['age'], '男' if dicts['sex'] == 1 else '女'
#             , datetime.datetime.strptime(str(dicts['birthyear']) + '-' + str(dicts['birthday']), '%Y-%m-%d')],
#         'friendPlace': [
#             dicts['uin'], dicts['company'],dicts['career'], dicts['hco'] + dicts['hp'] + dicts['hc'],
#                                                             dicts['country'] + dicts['province'] + dicts['city'],dicts['cco'] + dicts['cp'] + dicts['cc'], dicts['cb']],
#         'friendNet': [
#             dicts['uin'], dicts['nickname'], dicts['spacename'], dicts['desc'], dicts['signature']]
#     }
#     conn = pymssql.connect(host='localhost', user='sa', password='123456', database='friendDB',
#                            charset='utf8')
#     cur = conn.cursor()
#     sql = "begin tran insertData insert into friendInfo values({},'{}',{},'{}','{}');" \
#           "insert into friendPlace values({},'{}','{}','{}','{}','{}','{}');" \
#           "insert into friendNet values({},'{}','{}','{}','{}');" \
#           "commit tran insertData". \
#         format(friend_db_dict['friendInfo'][0],friend_db_dict['friendInfo'][1],friend_db_dict['friendInfo'][2]
#                ,friend_db_dict['friendInfo'][3],friend_db_dict['friendInfo'][4],friend_db_dict['friendPlace'][0],
#                friend_db_dict['friendPlace'][1],friend_db_dict['friendPlace'][2],friend_db_dict['friendPlace'][3],
#                friend_db_dict['friendPlace'][4],friend_db_dict['friendPlace'][5],friend_db_dict['friendPlace'][6],
#                friend_db_dict['friendNet'][0],friend_db_dict['friendNet'][1],friend_db_dict['friendNet'][2],
#                friend_db_dict['friendNet'][3],friend_db_dict['friendNet'][4])
#     print('sql: ',sql)
#     cur.execute(sql)
#     conn.commit()
#     cur.close()
#     conn.close()

def main():
    """主要操作

    :return: void
    """
    req = requests.session()
    headers={'host': 'h5.qzone.qq.com',
             'accept-encoding':'gzip, deflate, br',
             'accept-language':'zh-CN,zh;q=0.8',
             'accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
             'user-agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/'
                          '59.0.3071.115 Safari/537.36',
             'connection': 'keep-alive'}
    cookie = web_login_cookie()
    print('cookie',cookie)
    g_tk = get_key(cookie)
    qzonetoken_friend = get_key_values(cookie,'ptcz=')
    uin_friend = get_key_values(cookie,'ptui_loginuin=')
    rd_friend = get_key_values(cookie,'_qpsvr_localtk=')
    print('friend_data','qzontoken:%s;uin:%s;rd:%s' %(qzonetoken_friend,uin_friend,rd_friend))
    headers['Cookie']=cookie
    params_friend = {"uin": uin_friend,"fupdate": 1,"action": 1,"do":1,"g_tk":g_tk,"rd":rd_friend,
                     'qzonetoken':qzonetoken_friend}
    url_friend = 'https://user.qzone.qq.com/proxy/domain/r.qzone.qq.com/cgi-bin/tfriend/friend_ship_manager.cgi?'
    data_friend_str = send_requests(req,headers,url_friend,params=params_friend)
    data_friend_dict = loads(data_friend_str[0+len('_Callback('):data_friend_str.find(');')])
    print('data_friend_dict: ',data_friend_dict)
    if data_friend_dict['code'] != 0: # code = -3000 message = '请先登录'
        time.sleep(10)
        main()
    else:
        data_friend_list = list(data_friend_dict['data']['items_list'])
        for i in range(len(data_friend_list)):
            each_uin = data_friend_list[i]['uin']
            each_url = 'https://h5.qzone.qq.com/proxy/domain/base.qzone.qq.com/cgi-bin/user/cgi_userinfo_get_all?'
            params_each = {"uin": each_uin, "fupdate": 1, "vuin": uin_friend, "g_tk": g_tk, "rd": rd_friend,
                           'qzonetoken': qzonetoken_friend}
            time.sleep(1)
            data_each_str = send_requests(req,headers,each_url,params_each)
            try:
                data_each_dict = loads(data_each_str[0+len("_Callback("):data_each_str.find(");")])
            except json.decoder.JSONDecodeError as e:
                with open('leak.txt','a',encoding='utf8') as file: # 数据持久化，统计错误信息
                    file.write('except: ' + str(each_uin) + " " + data_friend_list[i]['name'] + " " + e.msg + "\n")
                    continue
            print('data_each_dict: ',data_each_dict)
            if data_each_dict['code'] == 0: # code = -4009 message = '没有访问权限'
                # friend_db(data_each_dict['data'],name=data_friend_list[i]['name'])
                print("没有访问权限")
            else:
                with open('leak.txt','a',encoding='utf8') as file: # 数据持久化，统计错误信息
                    file.write(('没有访问权限: ' + str(each_uin) + " " + data_friend_list[i]['name'] + "\n"))
main()