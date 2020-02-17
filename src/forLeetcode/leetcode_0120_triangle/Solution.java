package forLeetcode.leetcode_0120_triangle;

// 120 https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/

import java.util.ArrayList;
import java.util.List;

/*

三角形最小路径和



给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

动态规划

 */
class Solution {


    public static void main(String[] args) {
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();//行数
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {//从最后一行向上推演
            for (int i = 0; i <= level; i++) {   //第i行有i+1个数字 所以每一行的判断小件就是小于level
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
//   从最底层 遍历  ， 因为数组中默认都是0，所以从 minlen[0] 到minlen[3] 就是 最后一个的每一个数字
//   从倒数第二层 遍历，这个时候数组中已经有数据了，所以就可以比较哪一个最小的，然后和当前行的数加起来
//   自一层只有一个数了，
            }
        }
        return minlen[0];

    }

}