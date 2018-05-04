package com.tsj.common.utils;

public class PriceUtil {

    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] RADICES = {"", "拾", "佰", "仟"};
    private static final String[] BIG_RADICES = {"", "万", "亿", "兆"};
    /**
     * 获取大写的人名币的金额，单位精确到分
     * Create by andy on 2016-11-22 14:26
     *
     * @param money 人民币，单位：分
     * @return 人民币大写的金额
     */
    public static String getRMB(long money) {
        StringBuilder result = new StringBuilder("");
        if (money == 0) {
            return "零元整";
        }
        long integral = money / 100;//整数部分
        int integralLen = (integral + "").length();
        int decimal = (int) (money % 100);//小数部分
        if (integral > 0) {
            int zeroCount = 0;
            for (int i = 0; i < integralLen; i++) {
                int unitLen = integralLen - i - 1;
                int d = Integer.parseInt((integral + "").substring(i, i + 1));//当前数字的值
                int quotient = unitLen / 4;//大单位的下标{"", "万", "亿"}
                int modulus = unitLen % 4;//获取单位的下标（整数部分都是以4个数字一个大单位，比如：个、十、百、千、个万、十万、百万、千万、个亿、十亿、百亿、千亿）
                if (d == 0) {
                    zeroCount++;
                } else {
                    if (zeroCount > 0) {
                        result.append(CN_UPPER_NUMBER[0]);
                    }
                    zeroCount = 0;
                    result.append(CN_UPPER_NUMBER[d]).append(RADICES[modulus]);
                }
                if (modulus == 0 && zeroCount < 4) {
                    result.append(BIG_RADICES[quotient]);
                }
            }
            result.append("元");
        }
        if (decimal > 0) {
            int j = decimal / 10;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("角");
            }
            j = decimal % 10;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("分");
            }
        } else {
            result.append("整");
        }
        return result.toString();
    }
}
