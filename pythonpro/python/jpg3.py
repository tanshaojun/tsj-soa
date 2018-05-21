import requests
from bs4 import BeautifulSoup
import os

folder = 'C:\图片'
if not os.path.exists(folder):
    os.makedirs(folder)


# 定义一个函数，用以下载图片
def download(url):
    response = requests.get(url)
    name = url.split('/')[-1]
    f = open(folder + '/' + name + '.jpg', 'wb')
    f.write(response.content)
    f.close()


if __name__ == "__main__":
    header = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36'}
    # 循环改变url翻页
    for i in range(1, 5):
        url_i = 'https://tieba.baidu.com/f?kw=%E8%A1%A8%E6%83%85&ie=utf-8&pn=' + str(i*50)
        response_i = requests.get(url_i, headers=header)
        print(url_i)

        # 获取第i个页面的url、response类、html、soup，以及该页面所有图片对应的src
        html_i = response_i.text
        soup_i = BeautifulSoup(html_i, 'html.parser')
        imgs_i = soup_i.find_all('img', attrs={'class': 'BDE_Image'})

        for img in imgs_i:
            img_src = img.get('src')
            print(img_src)
            download(img_src)
    print('OK')
