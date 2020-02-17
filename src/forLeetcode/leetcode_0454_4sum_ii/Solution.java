package forLeetcode.leetcode_0454_4sum_ii;

/// Leetcode 454
/// https://leetcode-cn.com/problems/4sum-ii/


/*

四数相加 II

给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

 */

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        Set<String> s = new HashSet<>();
        s.add(null);
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "");
        }

        List<String> list = new ArrayList<>();
        list.add(null);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println("list is null");
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null, null);
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println("key:" + next + "");
            System.out.println("value:" + map.get(next));
        }

        Map<Integer, Integer> map1 = new TreeMap<>();
        map1.put(null, null);


    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];

                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }

        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(-A[i] - B[j])) {
                    res = res + map.get(-A[i] - B[j]);
                }
            }
        }


        return res;
    }

}
