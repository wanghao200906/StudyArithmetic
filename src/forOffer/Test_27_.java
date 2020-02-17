package forOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目：
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。
 * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba 。
 * <p>
 * 思路：
 * <p>
 * 把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。
 * <p>
 * 我们求整个字符串的排列，可以看成两步：首先求所有可能出现在第一个位置的字符，
 * 即把第一个字符和后面所有的字符交换。这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。
 * <p>
 * 这其实是很典型的递归思路。
 * <p>
 * 没看懂
 */

public class Test_27_ {


    public static void method() {
        System.out.println("Test_27_");

    }

    public static void main(String[] args) {

        method();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method();


        try {
            int a = 1 / 0;
        } catch (Exception e) {


        } finally {

        }

//        System.out.println(Permutation("abc"));
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0 || str == null) {
            return res;
        }
        helper(res, 0, str.toCharArray());
        Collections.sort(res);
        return res;

    }

    public static void helper(ArrayList<String> res, int index, char[] s) {
        if (index == s.length - 1) {
            res.add(new String(s));
        }
        for (int i = index; i < s.length; i++) {
            swap(s, index, i);
            helper(res, index + 1, s);
            swap(s, index, i);
        }

    }

    public static void swap(char[] t, int i, int j) {
        char c = t[i];
        t[i] = t[j];
        t[j] = c;
        System.out.println(t);
    }
}


