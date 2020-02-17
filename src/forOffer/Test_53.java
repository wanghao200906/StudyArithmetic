package forOffer;

/**
 * 题目：
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 例子说明
 * <p>
 * 例如，字符串“+100”，“5e2”，“-123”，“3.1416”及”-1E-16”都表示数值，
 * 但“12e”,”1a3.14”,”1.2.3”,”+-5”及“12e+5.4”都不是。
 * 思路：
 * 1.先判断第一位是不是正负号
 * 2.接着判断是不是0-9的字符
 * 3.判断是不是科学计数法
 * 1.判断是不是E|e
 * 2.判断是不是加减号
 * 3.判断其余的数组是不是0-9
 */

public class Test_53 {

    public static void main(String[] args) {
        System.out.println(isNum("6e2"));
//        System.out.println(isNum("-6e2"));
//        System.out.println(isNum("3.1415"));
        System.out.println(isNum("-1E-16"));
//
////        false 的例子
//        System.out.println(isNum("12e"));
//        System.out.println(isNum("22ssa"));
//        System.out.println(isNum("+-5"));
//        System.out.println(isNum("12e+5.1"));
    }

    static class Result {
        int start;
        boolean flag = true;
    }

    //    扫描字符串部分的数字部分
    public static void digit(char[] data, int start, int end, Result result) {
        while (start <= end) {
            if (data[start] >= '0' && data[start] <= '9') {
                start++;
            } else {
                result.start = start;
                return;
            }
        }
        result.start = start - 1;
    }

    //是否是科学计数法
    public static boolean isExponent(char[] data, int start, int end, Result result) {
        if (data[start] != 'e' && data[start] != 'E') {
            return false;
        }
        start++;
        if (data[start] == '+' || data[start] == '-') {
            start++;
        }
        if (start == end) {
            if (data[start] >= '0' && data[start] <= '9') {
                result.start = start;
                return true;
            } else {
                return false;
            }
        }
        digit(data, start, end, result);
        return result.start == end;
    }

    public static boolean isNum(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] data = str.toCharArray();
        int end = data.length - 1;
        Result result = new Result();
        int start = 0;
//        首位置是否为 + -  负号
        if (data[0] == '+' || data[0] == '-') {
            result.start = start + 1;
        }
        digit(data, result.start, end, result);
        if (result.start == end) {
            if (data[result.start] >= '0' && data[result.start] <= '9') {
                return true;
            } else {
                return false;
            }
        }
        if (data[result.start] == '.') {
            result.start++;
            digit(data, result.start, end, result);
            if (data[result.start] == 'e' || data[result.start] == 'E') {
                result.flag = isExponent(data, result.start, end, result);
            }
        } else if (data[result.start] == 'E' || data[result.start] == 'e') {
            result.flag = isExponent(data, result.start, end, result);
        } else {
            return false;
        }
        return result.start == end && result.flag;
    }
}

