package forOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 */
public class Test_32 {

    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        System.out.println(PrintMinNumber(arr));
    }

    public static String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int temp : numbers) {
            list.add(temp);
        }
        String s = "";
        //这里拼接其中两个进行比较
        //比如输入{3，32，321}，采用compare比较之后，变成了{321,32,3}
        //比较的根据是,比如3和32,332>323的，那么返回1，则交换这两个位置的数字
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        //拼接结果返回
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();


    }
}

