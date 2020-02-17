package forLeetcode.leetcode_0447_number_of_boomerangs;

/// Leetcode 447
/// https://leetcode-cn.com/problems/number-of-boomerangs/


/*
回旋镖的数量


给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:

输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]



149 和 719 题是一类问题。但是是困难的先不看了。


 */

import java.util.HashMap;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            hashMap.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (hashMap.containsKey(d)) {
                    res += hashMap.get(d) * 2;
                    hashMap.put(d, hashMap.get(d) + 1);
                } else {
                    hashMap.put(d, 1);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution()).numberOfBoomerangs(points));
    }
}
