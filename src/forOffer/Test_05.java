package forOffer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * <p>
 * 思路：
 * 栈1用于存储元素，栈2用于弹出元素，负负得正。
 * <p>
 * 现在把数据1、2、3分别入栈一，然后从栈一中出来（3、2、1），放到栈二中，那么，从栈二中出来的数据（1、2、3）就符合队列的规律了，即负负得正。
 * <p>
 * <p>
 * <p>
 * 扩展
 * 两个队列实现一个栈
 * <p>
 * 思路：
 * <p>
 * 队列1，2， 出入数据将数据放到队列1中。 取出数据的时候，将队列1的数据一个一个的插入到队列2中，当队列1中的数据只剩最后一个的时候
 * 将数据弹出，然后在将队列2中的数据全部的插入到队列1中。这样就实现了先进后出。
 */
public class Test_05 {
    public static void main(String[] args) throws Exception {
        MList<String> myList = new MList();
        myList.appendTail("123");
        myList.appendTail("123123");
        System.out.println(myList.deleteHead());
        System.out.println(myList.deleteHead());

        System.out.println("");

        MyStack<String> myStack = new MyStack<>();
        myStack.add("12fsdf");
        myStack.add("12fsdsdfsdgf");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }


    public static class MList<T> {
        // 插入栈，只用于插入的数据
        private Stack<T> stack1 = new Stack<>();
        // 弹出栈，只用于弹出数据
        private Stack<T> stack2 = new Stack<>();

        public MList() {
        }

        // 添加操作，成在队列尾部插入结点
        public void appendTail(T t) {
            stack1.add(t);
        }

        // 删除操作，在队列头部删除结点
        public T deleteHead() {

            // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
            // 并且将弹出的数据压入弹出栈中
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            // 如果弹出栈中还没有数据就抛出异常
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element.");
            }

            // 返回弹出栈的栈顶元素，对应的就是队首元素。
            return stack2.pop();
        }
    }


    public static class MyStack<T> {
        Queue<T> q1 = new LinkedList<>();
        Queue<T> q2 = new LinkedList<>();


        public void add(T t) {
            q1.add(t);
        }

        public T pop() throws Exception {
            if (q1.size() == 0) {
                throw new Exception("staci is null");
            }


            while (q1.size() > 0) {


                if (q1.size() == 1) {

                    T data = q1.poll();

                    while (q2.size() > 0) {
                        q1.add(q2.poll());
                    }

                    return data;

                }


                q2.add(q1.poll());
            }


            throw new Exception("staci is null");

        }


    }
}
