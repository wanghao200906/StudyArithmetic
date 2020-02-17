package forLeetcode.leetcode_0003_longest_substring_without_repeating_characters;

/// 3
/// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/



/*

无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbefg"));

    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1, res = 0;
        int[] freq = new int[256];


        while (l < s.length()) {

//            freq[s.charAt(r + 1)] == 0 的意思是查看一下r的下一个索引对应的字符是否已经重复了。
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                ++r;
                freq[s.charAt(r)]++;
            } else {
//                当r向右移动不了的时候就是一位r的下一位不是0了。
//所以要在这里进行减操作。让他重新为0.这样r就可以继续向右移动了。
                freq[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);

        }


        return res;


    }

}