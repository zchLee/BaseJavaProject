package com.lea.day6;

/**
 * @author aCheng
 * @create 2020/08/19 下午 6:05
 */
public class _2_String {

    public static void main(String[] args) {
//        String str = "中国";
//        System.out.println(str.length());
//
//        System.out.println(str.toCharArray().length);
//        String s = reverse("中华人民共和国", 2, 5);
//        System.out.println(s);

//        int count = getCount("abfhdjsabjfisoaabjiwab", "ab");

//        String maxSameString = getMaxSameString("sdafsafjshelloajfdioa", "hello");
//        System.out.println("最大相同字符串是" + maxSameString);

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);

        new StringBuffer(str);
    }

    /**
     * 将指定范围类字符串顺序反转
     *
     * @param str
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String reverse(String str, int startIndex, int endIndex) {
        if (str == null || "".equals(str))
            throw new NullPointerException("参数为空");
        if (startIndex < 0 || endIndex > str.length())
            throw new ArrayIndexOutOfBoundsException("参数异常");

        StringBuilder sb = new StringBuilder(str.substring(0, startIndex));
        char[] chars = str.substring(startIndex, endIndex).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
            sb.append(chars[i]);
        }
        sb.append(str.substring(endIndex));
        return sb.toString();
    }

    ;

    /**
     * 子字符串在主字符串中出现的次数
     *
     * @param mainStr
     * @param subStr
     * @return
     */
    public static int getCount(String mainStr, String subStr) {
        int count = 0;
        int index = 0;
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if (subLength > mainLength)
            return count;
        while ((index = mainStr.indexOf(subStr, index)) >= 0) {
            count++;
            index += subLength;
        }
        return count;
    }

    /**
     * 获取两个字符串中最大的相同子串
     * 例： 'sdafsafjshelloajfdioa' 'fdhelloa'
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxSameString(String str1, String str2) {
        if (null == str1 || null == str2)
            return null;
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++, y++) {
                String substring = minStr.substring(x, y);
                if (maxStr.contains(substring)) {
                    return substring;
                }
            }
        }
//        System.out.println("长度最大的字符串：" + maxStr);
//        System.out.println("长度最小的字符串：" + minStr);
        return null;
    }
}
