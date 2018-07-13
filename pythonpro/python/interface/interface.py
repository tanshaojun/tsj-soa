from flask import Flask
from flask import request,make_response
import requests
import xmltodict
import hashlib
import json
import time

app = Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'GET':
        signature = request.values.get('signature')
        token = "tanshaojun"
        timestamp = request.values.get('timestamp')
        print(timestamp)
        nonce = request.values.get('nonce')
        list = [token, timestamp, nonce]
        # 对token、timestamp和nonce按字典排序
        list.sort()
        # 将排序后的结果拼接成一个字符串
        list = ''.join(list)
        psw = hashlib.sha1(list.encode('utf8')).hexdigest()
        print(psw == signature)
        return request.values.get('echostr')
    else:
        msg = request.stream.read()
        data = xmltodict.parse(msg)
        jsonstr = json.dumps(data, indent=1)
        jsonstr = json.loads(jsonstr)
        msg = jsonstr['xml']['Content']
        MsgType = jsonstr['xml']['MsgType']
        ToUserName = jsonstr['xml']['ToUserName']
        FromUserName = jsonstr['xml']['FromUserName']
        url = "http://openapi.tuling123.com/openapi/api"
        data = {
            "key": "5asdas06af1a41eaa40cc",
            "info": msg
        }
        response = requests.post(url, data)
        api = response.json()
        Content=api['text']
        xmlstr="<xml><ToUserName>"+FromUserName+"</ToUserName><FromUserName>"+ToUserName+"</FromUserName><CreateTime>"+str(time.time())+"</CreateTime><MsgType>"+MsgType+"</MsgType><Content>"+Content+"</Content></xml>"
        res = make_response(xmlstr)
        res.content_type = 'application/xml'
        return res


if __name__ == '__main__':
    app.run(debug=True)
