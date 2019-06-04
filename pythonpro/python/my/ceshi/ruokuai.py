import requests


def get_verify_code(im, typeid):
    verify_code = '****'
    url = 'http://api.ruokuai.com/create.json'
    params = {
        'typeid': typeid,
        'timeout': 60,
        'username': 'tanshaojun',  # 用户名
        'password': 'tan123456',  # 密码
        'softid': '96061',  # 软件Id
        'softkey': '6facb9da7bb645ad9c4a229464b2cf89'  # 软件Key
    }
    files = {
        'image': ('a.jpg', im)
    }
    headers = {
        'Connection': 'Keep-Alive',
        'Expect': '100-continue',
        'User-Agent': 'ben'
    }
    try:
        resp = requests.post(url, data=params, files=files, headers=headers)
    except Exception as e:
        print('get_verify_code error: ', e)
        return verify_code
    try:
        verify_code = resp.json().get('Result', '')
    except Exception as e:
        print('get_verify_code failed: ', e)
        return verify_code
    if not verify_code:
        try:
            print(resp.text)
        except:
            print('verify code resp is None')

    return verify_code


def main():
    path = 'C:\\Users\\lenovo\\Desktop\\01.png'  # 图片路径
    with open(path, 'rb') as f:
        content = f.read()
    vcode = get_verify_code(content, 3040)
    print('--- vcode: ', vcode)


if __name__ == '__main__':
    main()
