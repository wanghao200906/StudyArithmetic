package forLeetcode.leetcode_0017_letter_combinations_of_a_phone_number;
// 17 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。



回溯法
 */
class Solution {


    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;

//        进行查找操作。
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {

//        如果index 等于digits说明我们找到了一个结果。
        if (index == digits.length()) {
            res.add(s);
            return;
        }
//index 不断的增加。来获取数字组合（比如23）的每一个元素（比如2），然后2对应的就是abc 在遍历这个abc。
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        //      不断地从头开始遍历每个letters 。这个letters 就是每个数字对应的 "abc" 等等
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

        return;
    }


}