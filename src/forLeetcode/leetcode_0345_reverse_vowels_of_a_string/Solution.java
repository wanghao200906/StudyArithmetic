package forLeetcode.leetcode_0345_reverse_vowels_of_a_string;

/// 345
/// https://leetcode-cn.com/problems/reverse-vowels-of-a-string/


/*

反转字符串中的元音字母

编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1:

输入: "hello"
输出: "holle"
示例 2:

输入: "leetcode"
输出: "leotcede"
说明:
元音字母 a e i o u
元音字母不包含字母"y"。


 */

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {


        String s = ".";
        System.out.println(reverseVowels(s));
    }


    public static String reverseVowels(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int l = nextVowel(chars, 0);
        int r = preVowel(chars, s.length() - 1);
        while (l < r) {
            swap(chars, l, r);
            l = nextVowel(chars, l + 1);
            r = preVowel(chars, r - 1);
        }

        return new String(chars);
    }

    private static void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

    private static int preVowel(char[] s, int i) {

        for (int i1 = i; i1 >=0; i1--) {
            if (isVowel(s[i1])) {
                return i1;
            }
        }
        return -1;
    }

    private static int nextVowel(char[] s, int i) {
        for (int i1 = i; i1 < s.length; i1++) {
            if (isVowel(s[i1])) {
                return i1;
            }
        }
        return s.length-1;
    }


    private static boolean isVowel(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
                || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c;
    }
}
