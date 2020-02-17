package forLeetcode.leetcode_0020_valid_parentheses;

import java.util.Stack;

/**
 * Leetcode 20.
 * https://leetcode.com/problems/valid-parentheses/description/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {

                if (stack.size() == 0)
                    return false;

                Character c = stack.pop();

                Character match;
                if (s.charAt(i) == ')')
                    match = '(';
                else if (s.charAt(i) == ']')
                    match = '[';
                else {
                    assert s.charAt(i) == '}';
                    match = '{';
                }

                if (c != match)
                    return false;
            }
        }
        if (stack.size() != 0)
            return false;

        return true;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new Solution()).isValid("(]"));
//        printBool((new Solution()).isValid("()[]{}"));
//        printBool((new Solution()).isValid("(]"));
//        printBool((new Solution()).isValid("([)]"));
    }
}
