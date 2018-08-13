import requests
from bs4 import BeautifulSoup

url = 'https://www.baidu.com/'
wbdata = requests.get(url).text
soup = BeautifulSoup(wbdata, 'lxml')
print(soup)
