package com.tsj.common.utils;

public class PasswordUtil {


    /**
     * 随机生成一个6位数密码
     * @return
     */
    public static String getSixRandNumber() {
        StringBuffer numStr = new StringBuffer();
        int num;
        String str="";
        for(int i=0;i<3;i++){
            str= str+(char) (Math.random ()*26+'A');
        }
        numStr.append(str);
        for (int i = 0; i < 6; i++) {
            // Math.random() 随机出0-1之间的实数，返回值是一个double 类型的
            num = (int) (Math.random() * 10);
            numStr.append(String.valueOf(num));
        }
        return numStr.toString();
    }
}
