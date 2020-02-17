package forLeetcode.leetcode_0011_container_with_most_water;

/// 11
// https://leetcode-cn.com/problems/container-with-most-water/



/*

盛最多水的容器

这个题没法描述，还是看网站。


示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49

*/

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            throw new IllegalArgumentException("invalid inputs");
        }

        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;

    }

}