import requests
import re
import execjs

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36',
}


def get_html(url):
    first_html = requests.get(url=url, headers=headers).content.decode('utf-8')
    return first_html


def executejs(first_html):
    # 提取其中的JS加密函数
    js_string = ''.join(re.findall(r'(function .*?)</script>', first_html))

    # 提取其中执行JS函数的参数
    js_arg = ''.join(re.findall(r'setTimeout\(\"\D+\((\d+)\)\"', first_html))
    js_name = re.findall(r'function (\w+)', js_string)[0]

    # 修改JS函数，使其返回Cookie内容
    js_string = js_string.replace('eval("qo=eval;qo(po);")', 'return po')

    func = execjs.compile(js_string)
    return func.call(js_name, js_arg)


def parse_cookie(string):
    string = string.replace("document.cookie='", "")
    clearance = string.split(';')[0]
    return {clearance.split('=')[0]: clearance.split('=')[1]}


def return_cookie(url):
    first_html = get_html(url)
    # 执行JS获取Cookie
    cookie_str = executejs(first_html)

    # 将Cookie转换为字典格式
    cookie = parse_cookie(cookie_str)
    print('cookies = ', cookie)
    return cookie


return_cookie(url='https://www.8btc.com/flash')

# 结果：
cookies = {'_ydclearance': '8c83e7fe9d6bd359e1eedc40-b55a-4ab5-98e2-22eb9b2ea9a7-1534917111'}
