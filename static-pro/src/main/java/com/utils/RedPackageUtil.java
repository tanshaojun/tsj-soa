package com.utils;

import java.util.Random;

/**
 * @Author tansj
 * @Date 2021/6/2 下午3:05
 * @Version 1.0
 */
public class RedPackageUtil {

    public static double getRandomMoney(RedPackage redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (redPackage.remainSize == 1) {
            redPackage.remainSize--;
            return (double) Math.round(redPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01; //
        double max = redPackage.remainMoney / redPackage.remainSize * 2;
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        redPackage.remainSize--;
        redPackage.remainMoney -= money;
        return money;
    }

    class RedPackage {
        int remainSize;
        int remainMoney;
    }
}
