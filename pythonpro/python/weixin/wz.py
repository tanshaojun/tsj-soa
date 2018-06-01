from string import ascii_lowercase as al
import urllib.request


def urliter():
    for i in range(100):
        print('%d/100' % i)
        for j in al:
            for k in al:
                yield "http://www.%02d%c%c%c%c.com" % (i, j, k, j, k)


logfile = open('C:\\tansj\\1.txt','a', encoding='utf8')
for u in urliter():
    try:
        wp = urllib.request.urlopen(u)
        print("find " + u)
        logfile.write(u + "\n")
    except:
        pass
logfile.close()
