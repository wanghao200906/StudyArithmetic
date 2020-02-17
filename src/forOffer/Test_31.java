package forOffer;

/**
 * 题目：
 * 输入一个整数n，求从1 到n这n个整数的十进制表示中1 出现的次数。
 * <p>
 * 举例说明：
 * <p>
 * 例如输入12 ，从1 到12 这些整数中包含1 的数字有1、10、11 和12，1 一共出现了5 次。
 * <p>
 * <p>
 * 思路：
 * 第一种：不考虑时间效率的解法
 * <p>
 * 累加1 到n 中每个整数中1出现的次数。我们可以每次通过对10 求余数判断整数的个位数字是不是1 。
 * 如果这个数字大于10，除以10 之后再判断个位数字是不是1 。
 * <p>
 * 其他方法暂时没想出来
 */
public class Test_31 {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_01(9));
    }

    /**
     * 方法1 ，暴力计算。穷举法
     *
     * @param num
     * @return
     */
    private static int NumberOf1Between1AndN_01(int num) {
        if (num <= 0) {
            return 0;
        }
        int counts = 0;
        for (int i = 1; i <= num; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    counts++;
                }
                temp /= 10;
            }
        }
        return counts;
    }

}

