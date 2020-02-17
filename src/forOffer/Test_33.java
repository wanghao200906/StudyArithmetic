package forOffer;

import java.util.ArrayList;

/**
 * 题目：
 * 我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 * <p>
 * 举例说明：
 * <p>
 * 例如6、8 都是丑数，但14 不是，它包含因子7。习惯上我们把1 当做第一个丑数。
 *
 * <p>
 * 思路：
 * https://www.nowcoder.com/profile/835689/codeBookDetail?submissionId=1522621
 */
public class Test_33 {

    public static void main(String[] args) {

        String[] arr = {"3", " 32", "321"};
        System.out.println(getUglyNumber2(100));
    }


    public static int getUglyNumber2(int n) {
        if (n <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < n)//循环的条件
        {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
//            每次把最小的放进来
            list.add(min);
//            三个里面选一个进行自增
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return list.get(list.size() - 1);
    }


}

