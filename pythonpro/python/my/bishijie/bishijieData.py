import requests
from bs4 import BeautifulSoup
from flask import Flask
from flask import request, make_response
import json
import pymysql

app = Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def getData():
    l = []
    url = "http://www.bishijie.com/hangqing/coin/bitcoin"
    wbdata = requests.get(url).text
    soup = BeautifulSoup(wbdata, 'html.parser')
    news_titles = soup.select("div > table > tbody > tr")
    for c in news_titles:
        tds = c.findAll("td")
        if tds != []:
            data = {
                'id': tds[0].getText().strip(),
                'tradingplatform': tds[1].getText().strip(),  # 交易平台
                'tradingpair': tds[2].getText().strip(),  # 交易对
                'usdprice': tds[3].findAll("i")[0].getText(),  # 美元价格
                'riseandfall': tds[4].getText().strip(),  # 涨跌幅
                'transaction': tds[5].findAll("span")[0].get_text(),  # 交易量
                'transactionpercentage': tds[5].findAll("i")[0].getText(),  # 交易量百分比
                'modified': tds[6].getText().strip()  # 更新时间
            }
            print(data)
            l.append(data)
    returnJson = json.dumps(l, ensure_ascii=False)
    print(returnJson)
    res = make_response(returnJson)
    res.content_type = 'application/json'
    return res


if __name__ == '__main__':
    # db = pymysql.connect("localhost", "root", "root", "saas_manage")
    # # 使用 cursor() 方法创建一个游标对象 cursor
    # cursor = db.cursor()
    #
    # # 使用 execute()  方法执行 SQL 查询
    # cursor.execute("SELECT VERSION()")
    #
    # # 使用 fetchone() 方法获取单条数据.
    # data = cursor.fetchone()
    #
    # print("Database version : %s " % data)
    #
    # # 关闭数据库连接
    # db.close()
    app.run(debug=True)
