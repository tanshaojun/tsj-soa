import itchat
# import全部消息类型
from itchat.content import *
import requests
import json


# 处理文本类消息
# 包括文本、位置、名片、通知、分享
@itchat.msg_register([TEXT, MAP, CARD, NOTE, SHARING])
def text_reply(msg):
    # 微信里，每个用户和群聊，都使用很长的ID来区分
    # msg['FromUserName']就是发送者的ID
    # 将消息的类型和文本内容返回给发送者
    print(msg)
    print("发送的：" + msg['Text'])
    url = "http://openapi.tuling123.com/openapi/api"
    data = {
        "key": "506af1a41eaa4248b5615662ab84e0cc",
        "info": msg['Text']
    }
    response = requests.post(url, data)
    api = response.json()
    print("我回复的：" + api['text'])
    itchat.send(api['text'], toUserName=msg['FromUserName'])
    # if msg['Text'] == '1':
    #     itchat.send("你好，我叫某某，我是世界上最帅的人哦。", toUserName=msg['FromUserName'])
    #     itchat.send("请发数字’2‘", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '2':
    #     itchat.send("儿子，你好，你爸爸在这里，哈哈", toUserName=msg['FromUserName'])
    #     itchat.send("请发数字’3‘", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '3':
    #     itchat.send("儿子，真乖，爸爸很感动", toUserName=msg['FromUserName'])
    #     itchat.send("请发数字’4‘", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '4':
    #     itchat.send("儿子，今天的聊天就到这里了，拜拜", toUserName=msg['FromUserName'])
    #     itchat.send("已退出.......", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '你好':
    #     itchat.send("我们来玩游戏吧：1 猜成语 2 字谜  3 成语接龙 4 退出", toUserName=msg['FromUserName'])
    # else:
    #     itchat.send("你好，我们来玩个游戏吧，要按照我说的做哦", toUserName=msg['FromUserName'])
    #     itchat.send("先发数字’1‘", toUserName=msg['FromUserName'])
    # itchat.send("你好,我是机器人", toUserName=msg['FromUserName'])


# 处理多媒体类消息
# 包括图片、录音、文件、视频
@itchat.msg_register([PICTURE, RECORDING, ATTACHMENT, VIDEO])
def download_files(msg):
    # msg['Text']是一个文件下载函数
    # 传入文件名，将文件下载下来
    print(msg)
    msg['Text'](msg['FileName'])
    # 把下载好的文件再发回给发送者
    # itchat.send("我不认识图片，发文字吧", toUserName=msg['FromUserName'])
    # return '@%s@%s' % ({'Picture': 'img', 'Video': 'vid'}.get(msg['Type'], 'fil'), msg['FileName'])

# 处理好友添加请求
# @itchat.msg_register(FRIENDS)
# def add_friend(msg):
#     # 该操作会自动将新好友的消息录入，不需要重载通讯录
#     itchat.add_friend(**msg['Text'])
#     # 加完好友后，给好友打个招呼
#     itchat.send_msg('Nice to meet you!', msg['RecommendInfo']['UserName'])

# 处理群聊消息
@itchat.msg_register(TEXT, isGroupChat=True)
def text_reply(msg):
    print(msg)
    print("发送的：" + msg['Text'])
    url = "http://openapi.tuling123.com/openapi/api"
    data = {
        "key": "506af1a41eaa4248b5615662ab84e0cc",
        "info": msg['Text']
    }
    response = requests.post(url, data)
    api = response.json()
    print("我回复的：" + api['text'])
    itchat.send(api['text'], toUserName=msg['FromUserName'])
    # if msg['Text'] == '1':
    #     itchat.send("猜成语", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '2':
    #     itchat.send("字谜", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '3':
    #     itchat.send("成语接龙", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '4':
    #     itchat.send("退出了", toUserName=msg['FromUserName'])
    # elif msg['Text'] == '你好':
    #     itchat.send("我们来玩游戏吧：1 猜成语 2 字谜  3 成语接龙 4 退出", toUserName=msg['FromUserName'])
    # else:
    #     # itchat.send("你说的这个我不懂哦（自动回复，请忽略）", toUserName=msg['FromUserName'])
    #     print(".....")


# 在auto_login()里面提供一个True，即hotReload=True
# 即可保留登陆状态
# 即使程序关闭，一定时间内重新开启也可以不用重新扫码
itchat.auto_login(hotReload=True)
itchat.run()
