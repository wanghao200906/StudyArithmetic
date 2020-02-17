package forLeetcode.leetcode_0338_counting_bits;
/// Source :https://leetcode-cn.com/problems/counting-bits/


/*
 比特位计数




给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]

示例 2:

输入: 5
输出: [0,1,1,2,1,2]


*/

public class Solution {

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 0; i <=num; i++) {
            arr[i] = help(i);
        }
        return arr;
    }

    private int help(int num) {
        int count ;
        for (count = 0; num != 0; count++) {
            num = num & (num - 1);
        }
        return count;
    }


}