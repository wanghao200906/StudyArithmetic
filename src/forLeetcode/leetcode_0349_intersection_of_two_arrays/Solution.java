package forLeetcode.leetcode_0349_intersection_of_two_arrays;

/// Leetcode 349. Intersection of Two Arrays
/// https://leetcode.com/problems/intersection-of-two-arrays/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/*


两个数组的交集



给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。


 */

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> record = new HashSet<Integer>();
        for(int num: nums1)
            record.add(num);

        HashSet<Integer> resultSet = new HashSet<Integer>();
        for(int num: nums2)
            if(record.contains(num))
                resultSet.add(num);

        int[] res = new int[resultSet.size()];
        int index = 0;
        for(Integer num: resultSet)
            res[index++] = num;

        return res;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

}
