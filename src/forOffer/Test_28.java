package forOffer;

/**
 * 题目：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *     因为全是数字，那么我开一个长度为10的数组，遍历原数组，根据计数的排序的思想，
 *     将新数组对应的索引值加一。遍历过程中发现某一个大于一半了就停止。
 */
public class Test_28 {
    public static void main(String[] args) {


    }

    public int MoreThanHalfNum_Solution(int[] array) {
        //由于全是数字，大小为10就足够了
        int[] bucket = new int[10];
        //遍历原数组，时间复杂度为O(n)
        for (int i = 0; i < array.length; i++) {
            //将对应索引加1
            bucket[array[i]]++;
            //找到了就停止
            if (bucket[array[i]] > array.length / 2) {
                return array[i];
            }
        }
        //找不到
        return 0;
    }
}


