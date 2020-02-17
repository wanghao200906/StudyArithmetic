package forLeetcode.leetcode_0202_happy_number;

// Leetcode 202
//https://leetcode-cn.com/problems/happy-number/



/*

快乐数


编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

 */


import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isHappy(18));
    }

    public static boolean isHappy(int n) {


        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {

            n = sum(n);

            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    private static int sum(int n) {


        int res = 0;

        while (n > 0) {

            int bit = n % 10;
            res = res + bit * bit;
            n = n / 10;
        }

        return res;
    }
}