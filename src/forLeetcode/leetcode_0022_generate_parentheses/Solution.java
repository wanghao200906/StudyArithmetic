package forLeetcode.leetcode_0022_generate_parentheses;

/// Source : https://leetcode-cn.com/problems/generate-parentheses/


/*


22. 括号生成

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneByOne("", result, n, n);
        return result;
    }

    private static void generateOneByOne(String s, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            generateOneByOne(s + "(", result, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(s + ")", result, left, right - 1);
        }
    }


}