from python.shell.sshutils import SSHConnectionUtils
import requests
import time

ssh = SSHConnectionUtils("47.95.10.20", "22", "root", "tan123456.")
ssh.connect()
# 远程关闭tomcat
print("关闭tomcat")
ssh.exec_command("/usr/local/tomcat8/bin/shutdown.sh")
time.sleep(1)

# 杀死进程
print('杀死进程')
ssh.exec_command('ps -ef | grep /usr/local/tomcat8 | awk \'{print $2}\' | xargs kill -15')
time.sleep(1)

# 清空日志
print("清空日志")
ssh.exec_command("rm -rf /usr/local/tomcat8/logs/*")
time.sleep(1)

# 远程删除工程
print('删除工程')
# ssh.exec_command('rm -rf /usr/local/tomcat8/webapps/ROOT')
time.sleep(1)

# 文件上传
print('上传war')
ssh.upload("C:\\Users\\lenovo\\Desktop\\test.war", "/root/test.war")

# 移动war包
print('移动war')
ssh.exec_command("mv /root/test.war /usr/local/tomcat8/webapps")

# 远程开启tomcat
print("开启tomcat")
ssh.exec_command("/usr/local/tomcat8/bin/startup.sh")
time.sleep(1)

# # 关闭ssh连接
ssh.close()
time.sleep(1)

# 检测是否成功
print("测试http://47.95.10.20:8080")
response = requests.get("http://47.95.10.20:8080")
print("http://47.95.10.20:8080", ' http code:', response.status_code)
if response.status_code == 200:
    print('Success!')
else:
    print('Fail !!!')
time.sleep(1)

# 下载
ssh.download("/root/aa.txt", "C:\\Users\\lenovo\\Desktop\\aa.txt")

# # 文件上传
# ssh.upload("C:\\Users\\lenovo\\Desktop\\test.war", "/root/test.war")
# time.sleep(1)
# # 下载
# ssh.exec_command("wget https://mirrors.cnnic.cn/apache/tomcat/tomcat-8/v8.0.53/bin/apache-tomcat-8.0.53.tar.gz ")
# # 解压
# ssh.exec_command("tar -axvf apache-tomcat-8.0.53.tar.gz")
# ssh.close()
