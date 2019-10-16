package com.other.JUC;

import com.utils.HttpUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5000);
    private static CyclicBarrier cyclicBarrierRun = new CyclicBarrier(5, () -> {
        System.out.println("我优先执行了..........");
    });

    public static void main(String[] args) {
        for (int i = 0; i < cyclicBarrierRun.getParties(); i++) {
            new Thread(new A()).start();
        }
    }

    private static class A implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "来了.......");
                cyclicBarrierRun.await();
                System.out.println("进来了");
//                String s = HttpUtils.doGetStr("http://localhost:8070/manage/login");
//                System.out.println(s);
                //并发请求的业务逻辑
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
