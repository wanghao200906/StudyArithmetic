package forOffer;

import java.util.Stack;

/**
 * 题目：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * <p>
 * 思路：
 * 把每次的最小元素（之前的最小元素和新压入战的元素两者的较小值）都保存起来放到另外一个辅助栈里。
 * <p>
 * 如果每次都把最小元素压入辅助栈， 那么就能保证辅助栈的栈顶一直都是最小元素．当最小元素从数据栈内被弹出之后，
 * 同时弹出辅助栈的栈顶元素，此时辅助栈的新栈顶元素就是下一个最小值。
 * <p>
 */
public class Test_20 {
    public static void main(String[] args) {


    }

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>(); //辅助栈：栈顶永远保存stack中当前的最小的元素


    public void push(int data) {
        stack.push(data);  //直接往栈中添加数据

        //在辅助栈中需要做判断
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.add(minStack.peek());   //【核心代码】peek方法返回的是栈顶的元素
        }
    }


    public int top() {

        return stack.peek();
    }


    public int pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("栈中为空");
        }

        int data = stack.pop();
        minStack.pop();  //核心代码
        return data;
    }

    public int min() throws Exception {
        if (minStack.size() == 0) {
            throw new Exception("栈中空了");
        }
        return minStack.peek();
    }
}


