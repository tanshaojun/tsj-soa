# cookie模拟登录

import requests

raw_cookies = "managesid=23c12cef-5ecf-4d83-9975-9a461e10fc80; rememberMe=Y3XFP5mUO13whtwkE/xcMw44UUn9+Xu+PNAg9j82PTbSzcAG+iSIjV90TAx+rtltchbdw+Q8cBKtexlVsGO9Qg/Payzb5ud2pUZEx5VXGi5omIagHLK3etEZpWb16pJ6WivEexK2fbXIoHTpB+BtQ7MDcrewIhbUuj96sqeEfgk3d5R0I724JxezNYp6MrM2pkPU5whEYcCw0zx6iFyU7Sw/zmxdPY/v3yYjn8T0ysxV1w13bTBidFbMMitnK49YqX2rWfU8rxh4Y+z6aHax/jA1/L6KL+JGOCplhFlLRyBm7HDgDMjYwlgTO8gFnNuXaWbJWydabsa8Q36V//Q8w59CWtascLHRm6g1CJcDRSNM6r3gIbSG9Ipi5nkO4kaQQIWlu+Dh6f07MKDAMjguT+rzpfLNF6hUjm4hhfHOhCu3Neqanx2KANRK6mXDNYbigGzwbAx6HqsINFMRqlDlCZ0bbrrrSR5c4mWZKN0p92bsQI4CpDv1LOY5tm+MdLF5Grp6S6cp+ae4tNLpKdE+9/cW4CFPTDOPhXgBuT9ff30="
cookies = {}
for line in raw_cookies.split(';'):
    key, value = line.split('=', 1)  # 1代表只分一次，得到两个数据
    cookies[key] = value

# print(cookies)

url = "http://47.93.54.20/checklogin"
headers = {
    'User-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'}
resp = requests.get(url, headers=headers, cookies=cookies)
print(resp.text)
