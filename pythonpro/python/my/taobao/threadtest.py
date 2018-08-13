from threading import Thread
import queue

my_queue = queue.Queue()


class MyThread1(Thread):
    def __init__(self):
        Thread.__init__(self)
        # super(MyThread1, self).__init__()

    def run(self):
        k = 1
        while True:
            put_data = "you producer data"
            my_queue.put_nowait(put_data)
            print(put_data + str(k))
            k = k + 1

    # pass


class MyThread2(Thread):
    def __init__(self):
        Thread.__init__(self)
        # super(MyThread2, self).__init__()

    def run(self):
        while True:
            get_data = my_queue.get()
            print(get_data)
        # pass


if __name__ == '__main__':
    thread1 = MyThread1()
    thread2 = MyThread2()
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
