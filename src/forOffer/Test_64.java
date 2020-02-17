package forOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * <p>
 * 举例说明
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小为3，那么一共存在6个滑动窗口，
 * 它们的最大值分别为{4,4,6,6,6,5}。
 * <p>
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 用双端队列，可以用LinkedListed .滑动的时候保证队列的队首永远是最大值
 * 队列里面保存的是数组的索引。
 */

public class Test_64 {

    public static void main(String[] args) {

        int[] arr = { 4, 2, 1, -2, 5, 1};
        List<Integer> list = maxInWindows(arr, 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        //存放当前窗口中最大值
        ArrayList<Integer> res = new ArrayList<>();
        //队列的头部存放的是当前窗口最大值
        LinkedList<Integer> queue = new LinkedList<>();
        if(num == null || num.length <= 0 || size <= 0){
            return res;
        }

        for(int i=0;i<num.length;i++){
            //比如当前数据比队尾的数字大，说明当前这个数字最起码在从现在起到后面的过程中可能是最大值
            //而之前队尾的数字不可能最大了，所以要删除队尾元素。
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]){
                queue.pollLast();
            }
            queue.add(i);
            //队头的元素是否超过窗口的范围
            if(queue.peekFirst() == i-size){
                queue.pollFirst();
            }
            //在包含了三个元素之后才开始记录，其中最大值就在队列的头部
            if(i >= size - 1){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }
}

