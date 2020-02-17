package forLeetcode.leetcode_0242_valid_anagram;

// Leetcode 242.
// https://leetcode-cn.com/problems/valid-anagram/


import java.util.HashMap;
import java.util.HashSet;

/*
有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:
输入: s = "anagram", t = "nagaram"
输出: true

示例 2:
输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 */
public class Solution2 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    }

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


}