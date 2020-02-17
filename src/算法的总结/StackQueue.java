package 算法的总结;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//两个栈实现一个队列
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小数的min 函数。在该栈中，调用min、push 及pop的时间复杂度都是O(1)。
// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小数的min 函数。在该栈中，调用min、push 及pop的时间复杂度都是O(1)。
public class StackQueue {


//    两个栈实现一个队列

    public class MyQueue {
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        public void addTail(String s) {
            s1.push(s);
        }

        public String deleteHead() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            if (s2.isEmpty()) {
                throw new IllegalArgumentException("invalid inputs");
            }
            return s2.pop();
        }

    }
    //   两个队列实现一个栈

    public class MyStack {
        LinkedList<String> q1 = new LinkedList<>();
        LinkedList<String> q2 = new LinkedList<>();

        public void add(String s) {
            q1.add(s);
        }

        public String pop() {
            if (q1.isEmpty()) {
                throw new IllegalArgumentException("invalid inputs");
            }

            while (q1.size() > 0) {

                if (q1.size() == 1) {
                    String s = q1.poll();

                    while (q2.size() > 0) {
                        q1.add(q2.poll());
                    }

                    return s;
                }

                q2.add(q1.poll());
            }
            throw new IllegalArgumentException("invalid inputs");

        }
    }

    // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
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


// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小数的min 函数。在该栈中，调用min、push 及pop的时间复杂度都是O(1)。

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(Integer i) {
        s1.push(i);
        if (min.size() == 0 || i < min.peek()) {
            min.push(i);
        } else {
            min.push(min.peek());
        }
    }

    public Integer pop() {
        Integer i = s1.pop();
        min.pop();
        return i;
    }

    public Integer min() {
        return min.peek();
    }


//    输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。

    public static boolean sequenseIsPop(int[] data1, int[] data2) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 0; i < data1.length; i++) {
            s.push(data1[i]);
            while (!s.isEmpty() && s.peek() == data2[j]) {
                j++;
                s.pop();
            }
        }
        return s.size() == 0;
    }

}
