import requests
import xlrd
import xlutils.copy
from lxml import etree
import time

filename = "C:/Users/lenovo/Desktop/data.xls"


def readline():
    wb = xlrd.open_workbook(filename, formatting_info=True)  # 打开excel，保留文件格式
    sheet1 = wb.sheet_by_index(0)  # 获取第一张表
    nrows = sheet1.nrows  # 获取总行数
    ncols = sheet1.ncols
    return nrows


def write(a, b):
    data = xlrd.open_workbook(filename)
    ws = xlutils.copy.copy(data)  # 复制之前表里存在的数据
    table = ws.get_sheet(0)
    nownrows = readline()
    table.write(nownrows, 0, label=a)  # 最后一行追加数据
    table.write(nownrows, 1, label=b)
    ws.save(filename)  # 保存的有旧数据和新数据


filters = ["征信", "二代征信", "担保", "融资", "信贷", "贷", "溯源", "溯源电商", "农产品溯源", "保理", "应收", "账款", "供应链金融"]


def caigou2003():
    size = 1
    while size < 3:
        print("当前第" + str(size) + "页")
        try:
            url = "http://www.caigou2003.com/tender/notice/index_%s.html"
            if size > 1:
                url = url % size
            else:
                url = "http://www.caigou2003.com/tender/notice/"
            response = requests.get(url).content.decode('utf-8')
            info = etree.HTML(response)
            uls = info.xpath("//div[@class='news']/ul")
            for ul in uls:
                lis = ul.xpath("./li")
                for li in lis:
                    title = li.xpath("./h3/a/text()")[0]
                    for f in filters:
                        if f in title:
                            print(title)
                            # span = li.xpath("./span/text()")[0]
                            font = li.xpath("./font/text()")[0]
                            write(title, font)
                            break
        except Exception as e:
            print(str(size) + '报错: ', e)
        time.sleep(5)
        size += 1


if __name__ == '__main__':
    caigou2003()
