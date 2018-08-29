import os
import paramiko


class SSHConnectionUtils:
    __hostname = ''
    __port = 22
    __username = ''
    __password = ''
    __ssh = ''

    def __init__(self, hostname, port, username, password):
        self.__hostname = hostname
        self.__port = port
        self.__username = username
        self.__password = password

    # 连接
    def connect(self):
        print('ssh 连接中 %s@%s ....' % (self.__username, self.__hostname))
        try:
            self.__ssh = paramiko.SSHClient()
            self.__ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
            self.__ssh.connect(hostname=self.__hostname, username=self.__username, port=self.__port,
                               password=self.__password)
            print('ssh连接 %s@%s 成功......' % (self.__username, self.__hostname))
        except Exception as e:
            print('ssh连接失败 %s@%s: %s' % (self.__username, self.__hostname, e))
            self.exit()

    # 执行命令
    def exec_command(self, command):
        print('命令为：:', command)
        stdin, stdout, stderr = self.__ssh.exec_command(command)
        err_list = stderr.readlines()
        if len(err_list) > 0:
            print('ssh 执行命令 [%s] 错误: %s' % (command, err_list[0]))
        print(stdout.read().decode('utf-8'))

    # 文件上传
    def upload(self, src, dst):
        try:
            sftp = self.__ssh.open_sftp()
        except Exception as e:
            print('开启sftp失败:', e)
            self.exit()
        try:
            print('上传文件: %s --> %s' % (src, dst))
            sftp.put(src, dst)
            sftp.close()
        except Exception as e:
            print('上传文件失败:', e)
            self.exit()

    # 文件下载
    def download(self, downloadAddress, toAddress):
        try:
            sftp = self.__ssh.open_sftp()
        except Exception as e:
            print('开启sftp失败:', e)
            self.exit()
        try:
            print('下载文件: %s --> %s' % (downloadAddress, toAddress))
            sftp.get(downloadAddress, toAddress)
            sftp.close()
        except Exception as e:
            print('下载文件失败:', e)
            self.exit()

    # 关闭连接
    def close(self):
        self.__ssh.close()

    # python程序终止
    def exit(self):
        os._exit(0)
