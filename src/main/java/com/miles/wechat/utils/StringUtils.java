package com.miles.wechat.utils;

/**
 * @author miles
 * @datetime 2014/4/16 16:55
 */
public class StringUtils {
    /**
     * 判断一个字符串是否为空或者空字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 字节转字符串
     *
     * @param mByte
     * @return
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteToStr(byte[] byteArray) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            buffer.append(byteToHexStr(byteArray[i]));
        }
        return buffer.toString();
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param src
     * @param dest
     * @return
     */
    public static boolean equals(String src, String dest) {
        if (src == dest) return true;

        if (isEmpty(src) || isEmpty(dest)) {
            return false;
        }
        if (src.trim().equals(dest.trim())) {
            return true;
        }
        return false;
    }
}
