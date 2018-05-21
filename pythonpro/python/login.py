# cookie模拟登录

import requests

raw_cookies = "managesid=e92b3abc-ce20-4d68-8a30-ade42055d3ef; rememberMe=AF2I+WYoruadC41Wt9A0/ebeWu+VM/oXyeGBnvodxfOmJ7u+i5O06UqDW5MiUJFhnKC6A5gij0MbNho35u6t90a4jW83zDwmqukBs80M+t/DuMQh9Bwvhhi8sSChM2c0IxoKWuCkKr+/55zq92Nbyd1WkC0ovsiW5aR03JfaDrX8qkAcejOo/2ifMhzCYgyY8B/jj2Br2YlvL8fqqGvynCxEfXtLcNHN36Ssp9VHlboQ3pBtjt84BvPNDzjnOpAmrL9VtbOYRGfGBdRq8KqNS/TgE/16AAsIujB9jEE5GGsjDh5PRs2gWIfnWJqQxORNGyUEEbGsIxjiDiw3X23Rq0ol+zbKzYCcedjbGEf5IRaiWb0Z71mtlc0v+sJaStTvTZWbHFkfX96fFW432W8TVEy27O2trPJcVaHc/51XLZl67CoRKoSegpwhKns9kNQV7VZw6EG6dJY3uZilum68KBFvGPLPtfVmK8Pi9LmRPQNfgatu8Bay8l1zgXhLVKRFzdGQRls/CAQyomafCNU6TaHMB5Zeq7+2IVuPikO4kCA=";
cookies = {}
for line in raw_cookies.split(';'):
    key, value = line.split('=', 1)  # 1代表只分一次，得到两个数据
    cookies[key] = value

print(cookies)

url = "http://47.93.54.20/checklogin"
headers = {
    'User-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'}
resp = requests.get(url, headers=headers, cookies=cookies)
print(resp.text)
