package forLeetcode.leetcode_0438_find_all_anagrams_in_a_string;

/// Leetcode 438
/// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/


/*
找到字符串中所有字母异位词

给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

0的意思就是 从0开始 有 cba 和 abc 拥有的字母一样
6的意思就是 从6开始 有bac 和 abc 拥有的字母一样


 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
//
//    public static void main(String[] args) {
//        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
//        for (int i = 0; i < anagrams.size(); i++) {
//            System.out.println(anagrams);
//        }
//    }
//
//    public static List<Integer> findAnagrams(String s, String p) {
//
//    }
}
