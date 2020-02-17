package 算法的总结;

//请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。

import java.util.ArrayList;
import java.util.Collections;

//输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba 。
public class zifuchuan {

    //    请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
    public String convert(String str) {
        if (str == null && str.length() < 1) {
            return null;
        }
        int oldLength = 0, blankNum = 0;
        while (oldLength < str.length()) {
            if (str.charAt(oldLength) == ' ') {
                blankNum++;
            }
            oldLength++;
        }
        int newLength = oldLength + 2 * blankNum;
        char[] content = new char[newLength];
        int oldIndex = oldLength - 1;
        int newIndex = newLength - 1;
        while (oldIndex >= 0) {

            if (str.charAt(oldIndex) == ' ') {
                content[newIndex--] = '0';
                content[newIndex--] = '2';
                content[newIndex--] = '%';
            } else {
                content[newIndex--] = str.charAt(oldIndex);
            }
            oldIndex--;
        }
        return new String(content);

    }
//输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba 。
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0 || str == null) {
            return res;
        }
        int n = str.length();
        helper(res, 0, str.toCharArray());
        Collections.sort(res);
        return res;

    }

    public static void helper(ArrayList<String> res, int index, char[] s) {
        if (index == s.length - 1) {
            res.add(new String(s));
        }
        for (int i = index; i < s.length; i++) {
            if (i == index || s[index] != s[i]) {
                swap(s, index, i);
                helper(res, index + 1, s);
                swap(s, index, i);
            }
        }

    }

    public static void swap(char[] t, int i, int j) {
        char c = t[i];
        t[i] = t[j];
        t[j] = c;
        System.out.println(t);
    }
}
