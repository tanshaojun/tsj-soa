import time

import requests
import xlrd
import xlutils.copy

filename = "C:/Users/lenovo/Desktop/data.xls"


def readline():
    wb = xlrd.open_workbook(filename, formatting_info=True)  # 打开excel，保留文件格式
    sheet1 = wb.sheet_by_index(0)  # 获取第一张表
    nrows = sheet1.nrows  # 获取总行数
    ncols = sheet1.ncols
    return nrows


def write(a, b, c):
    data = xlrd.open_workbook(filename)
    ws = xlutils.copy.copy(data)  # 复制之前表里存在的数据
    table = ws.get_sheet(0)
    nownrows = readline()
    table.write(nownrows, 0, label=a)  # 最后一行追加数据
    table.write(nownrows, 1, label=b)
    table.write(nownrows, 2, label=c)
    ws.save(filename)  # 保存的有旧数据和新数据


filters = ["征信", "二代征信", "担保", "融资", "信贷", "贷", "溯源", "溯源电商", "农产品溯源", "保理", "应收", "账款", "供应链金融"]


def dealggzygov():
    size = 1
    while size < 10:
        print("当前第" + str(size) + "页")
        try:
            url = "http://deal.ggzy.gov.cn/ds/deal/dealList_find.jsp"
            data = {
                "TIMEBEGIN_SHOW": "2020-06-19",
                "TIMEEND_SHOW": "2020-06-28",
                "TIMEBEGIN": "2020-06-19",
                "TIMEEND": "2020-06-28",
                "SOURCE_TYPE": "1",
                "DEAL_TIME": "04",
                "DEAL_CLASSIFY": "00",
                "DEAL_STAGE": "0000",
                "DEAL_PROVINCE": "0",
                "DEAL_CITY": "0",
                "DEAL_PLATFORM": "0",
                "BID_PLATFORM": "0",
                "DEAL_TRADE": "0",
                "isShowAll": "1",
                "PAGENUMBER": size,
                "FINDTXT": "",
            }
            response = requests.post(url, data=data)
            json = response.json()
            if json['success']:
                datas = json['data']
                for data in datas:
                    title = data['title']
                    for f in filters:
                        if f in title:
                            print(title)
                            time_show = data['timeShow']
                            url = data['url']
                            write(title, time_show, url)
                            break
        except Exception as e:
            print(str(size) + '报错: ', e)
        time.sleep(5)
        size += 1


if __name__ == '__main__':
    dealggzygov()
