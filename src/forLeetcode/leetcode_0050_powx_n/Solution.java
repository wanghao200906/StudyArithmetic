package forLeetcode.leetcode_0050_powx_n;

//  50
/// https://leetcode-cn.com/problems/powx-n/


/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25


*/


public class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 3));
        System.out.println(Solution.fastPow(2.0, 2));
    }

    private static double fastPow(double x, long n) {
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

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }


}