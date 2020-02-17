package forLeetcode.leetcode_0080_remove_duplicates_from_sorted_array_ii;
/// Source :https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/


/*

题目：删除排序数组中的重复项 II

给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定 nums = [1,1,1,2,2,3],

函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,1,2,3,3],

函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。

你不需要考虑数组中超出新长度后面的元素。


思路：
快慢双指针，因为要求可以最多有两个元素一样，所以要用当前元素之和往前数两个元素进行对比。
满指针index永远都是要被更改的那个元素。
*/

public class Solution {
    public static void main(String[] args) {


    }

    public int removeElement(int[] nums) {

        int index = 2;
        for (int i = 2; i < nums.length; i++) {
//            这里的index-2就是因为有两个元素相等。如果三个就index-3
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}