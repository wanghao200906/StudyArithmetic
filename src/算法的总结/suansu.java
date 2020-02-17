package 算法的总结;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数  .一个递归,思想就是二分 幂数
//买卖股票的最佳时机 II ，贪心算法。给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
//    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

//写一个函数，输入n，求斐波那契数列的第n项值。
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

//    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
// 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分

//  输入一个整数n，求从1 到n这n个整数的十进制表示中1 出现的次数。
// 一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复
import java.util.PriorityQueue;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有值排序之后位于中间的数值。如果数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
public class suansu {


    //实现 pow(x, n) ，即计算 x 的 n 次幂函数  .一个递归

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }


    //买卖股票的最佳时机 II ，贪心算法。给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);//这个算法就是删除掉二进制数的最后一位的1. 把1都删除了就是0了。
        }
        return count;
    }
//    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    //    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            arr[i] = help(i);
        }
        return arr;
    }

    private int help(int num) {
        int count;
        for (count = 0; num != 0; count++) {
            num = num & (num - 1);
        }
        return count;
    }

    //    写一个函数，输入n，求斐波那契数列的第n项值。
    public int Fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    public int JumpFloor(int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return 1;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }


    }

    //    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    //    请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
    public static int numberOfOne2(int n) {
        // 记录数字中1的位数
        int result = 0;

        // 数字的二进制表示中有多少个1就进行多少次操作
        while (n != 0) {
            result++;
            // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
            // 即使是符号位也会进行操作。
            n = (n - 1) & n;
        }

        // 返回求得的结果
        return result;
    }
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分


    public static void reOrderArray2(int[] a) {
        if (a == null || a.length == 0)
            return;
        int i = 0, j;
        while (i < a.length) {
//            找到偶数
            while (i < a.length && !isEven(a[i]))
                i++;
            j = i + 1;
//            找到奇数
            while (j < a.length && isEven(a[j]))
                j++;
            if (j < a.length) {
                int tmp = a[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    a[j2 + 1] = a[j2];
                }
                a[i++] = tmp;
            } else {// 查找失敗
                break;
            }
        }
    }

    static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }


    //如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有值排序之后位于中间的数值。如果数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    private PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> (o1 - o2));
    private PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> (o1 - o2));
    int count = 0;

    public void insert(int num) {
        if (count % 2 == 0) {
            max.add(num);
            int tmp = max.poll();
            min.add(tmp);
        } else {
            min.add(num);
            int tmp = min.poll();
            max.add(tmp);
        }
    }

    public Double getMedian() {
        if (count % 2 == 0) {
            return new Double(max.peek() + min.peek()) / 2;
        } else {
            return new Double(min.peek());
        }

    }
//  输入一个整数n，求从1 到n这n个整数的十进制表示中1 出现的次数。

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
// 一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复


    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] result = {0, 0};

        if (data == null || data.length < 2) {
            return result;
        }

        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }

//        xor的值是数组中没有的，因为是数组中 两个只出现一次的数 进行异或的结果
        int indexOf1 = findFirstBit1(xor);

        for (int i : data) {
            if (isBit1(i, indexOf1)) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }

        return result;
    }

    //    num转为二进制，从二进制数中找到 第一个1的那一位。
//    这个1怎么得到的？是数组中的两个不同的数进行异或操作，得到的。可以通过这个1来将数组分成两波，数组中肯定有一部分这一位是1，有一部分这一位是0
    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
//            如果和1与操作为0且小于32 说明这一位不是1，就向右移动一位。
            num >>>= 1;
            index++;
        }

        return index;
    }

    //判断num这一位是否是1，进行分组用的
    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }
}
