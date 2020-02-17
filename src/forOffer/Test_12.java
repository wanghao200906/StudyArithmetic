package forOffer;

/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0

https://leetcode-cn.com/problems/powx-n/
 */
public class Test_12 {

    public double Power(double base, int exponent) {

        int n = exponent;
        if (n < 0) {
            base = 1 / base;
            n = -n;
        }
        return help(base, n);
    }

    public double help(double base, int n) {
        if (n == 0) {
            return 1;
        }
        double half = help(base, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * base;
        }
    }


}
