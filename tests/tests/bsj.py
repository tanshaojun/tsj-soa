import requests
from bs4 import BeautifulSoup
from django.http import HttpResponse
import json
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt


@csrf_exempt
def getData(request):
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
            # print(data)
            l.append(data)
    # returnJson = json.dumps(l, ensure_ascii=False)
    # print(returnJson)
    return JsonResponse(l, safe=False)
