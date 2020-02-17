package forOffer;

import java.util.Stack;

/**
 * 题目：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * <p>
 * 思路：
 * 解决这个问题很直观的想法就是建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从该栈中弹出数
 * 字。
 *
 * 判断一个序列是不是栈的弹出序列的规律：
 * 将数列1的数字 遍历 入栈，然后在判断栈顶的数据和 序列2中的数据是否相等，如果相等让序列2的所以 j++，同时让栈顶的数据出站。
 * 最后遍历完 栈的数量应为0 就说明 序列二位序列一的出栈顺序。
 * <p>
 */
public class Test_21 {
    public static void main(String[] args) {


    }
    //方法：data1数组的顺序表示入栈的顺序。现在判断data2的这种出栈顺序是否正确
    public static boolean sequenseIsPop(int[] data1, int[] data2) {
        Stack<Integer> stack = new Stack<Integer>(); //这里需要用到辅助栈

        for (int i = 0, j = 0; i < data1.length; i++) {
            stack.push(data1[i]);
            while (stack.size() > 0 && stack.peek() == data2[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.size() == 0;
    }
}


