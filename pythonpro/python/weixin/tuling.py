import requests
import json

url = "http://openapi.tuling123.com/openapi/api"
data = {
    "key": "506af1a41eaa4248b5615662ab84e0cc",
    "info": "你好"
}
response = requests.post(url, data)
api=response.json()
print(api['text'])
