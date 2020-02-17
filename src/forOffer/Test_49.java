package forOffer;

/**
 * 题目：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 思路：
 * 主要是考察严谨，比如空指针 溢出等问题
 */

public class Test_49 {

    public static void main(String[] args) {
        System.out.println(parseInt("-2147483649"));
//        System.out.println(parseInt(Integer.MAX_VALUE + ""));
//        System.out.println(parseInt("+"));
    }

    public static int parseInt(String str) {
        if (str == null) {
            throw new RuntimeException("str is null");
        }
        if(str.isEmpty()){
            return 0;
        }
        char[] data = str.trim().toCharArray();
        boolean isPositive = true;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int index = 0;
//       判断正负数
        if (data[0] == '+') {
            isPositive = true;
            index++;
        } else if (data[0] == '-') {
            isPositive = false;
            index++;
        }
        if (data.length <= index) {
//            throw new RuntimeException(" please input a real number ");
            return 0;
        }
        long result = 0;
        for (int i = index; i < data.length; i++) {
//            是一个数字
            if (data[i] >= '0' && data[i] <= '9') {
                result = result * 10 + (data[i] - '0');
//                最大值最小值进行判断
                if (isPositive && result > max) {
                    // throw new RuntimeException(" str > Integer.MAX_VALUE ");
                    return 0;
                } else if (!isPositive && (-result < min)) {
//                    throw new RuntimeException(" str < Integer.MIN_VALUE ");
                    return 0;
                }
            } else {
                //throw new RuntimeException("str can't parse int ");
                return 0;
            }
        }
        return (int) (isPositive ? result : -result);
    }

}

