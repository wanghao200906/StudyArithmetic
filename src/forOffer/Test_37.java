package forOffer;

/**
 * 题目：
 * 统计一个数字：在排序数组中出现的次数。
 * <p>
 * 举例说明
 * <p>
 * 例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字3 ，由于3 在这个数组中出现了4 次，因此输出4 。
 * 思路：
 * <p>
 * 利用改进的二分算法。
 * <p>
 * 如何用二分查找算法在数组中找到第一个k，二分查找算法总是先拿数组中间的数字和k作比较。如果中间的数字比k大，那么k只有可能
 * 出现在数组的前半段，下一轮我们只在数组的前半段查找就可以了。如果中间的数字比k小，那么k只有可能出现在数组的后半段，下一轮
 * 我们只在数组的后半段查找就可以了。如果中间的数字和k 相等呢？我们先判断这个数字是不是第一个k。如果位于中间数字的前面一个
 * 数字不是k,此时中间的数字刚好就是第一个k。如果中间数字的前面一个数字也是k，也就是说第一个k肯定在数组的前半段，
 * 下一轮我们仍然需要在数组的前半段查找。
 * <p>
 * 同样的思路在排序数组中找到最后一个k。如果中间数字比k大，那么k只能出现在数组的前半段。如果中间数字比k小，k就只能出现在数
 * 组的后半段。如果中间数字等于k呢？我们需要判断这个k是不是最后一个k，也就是中间数字的下一个数字是不是也等于k。如果下一个
 * 数字不是k，则中间数字就是最后一个k了：否则下一轮我们还是要在数组的后半段中去查找。
 * <p>
 * 因为是有序的所以找到最后一个k的位置 建议第一个k的位置就是 一共有多少个k了
 */
public class Test_37 {

    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(arr,3));
    }

    /**
     * 题目：统计一个数字：在排序数组中出现的次数
     *
     * @param data
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if (data != null && data.length > 0) {
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
    }

    /**
     * 找排序数组中k第一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx > 0 && data[midIdx - 1] != k || midIdx == 0) {
                return midIdx;
            } else {
                end = midIdx - 1;
            }
        } else if (midData > k) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }

        return getFirstK(data, k, start, end);
    }

    /**
     * 找排序数组中k最后一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        } else {
            end = midIdx - 1;
        }

        return getLastK(data, k, start, end);
    }

}

