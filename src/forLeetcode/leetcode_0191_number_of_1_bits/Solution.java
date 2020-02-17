package forLeetcode.leetcode_0191_number_of_1_bits;

// Leetcode 191
// https://leetcode-cn.com/problems/number-of-1-bits/

/*

191. 位1的个数

编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。


 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);//这个算法就是删除掉二进制数的最后一位的1. 把1都删除了就是0了。
        }
        return count;

    }


}