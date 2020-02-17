package 其他算法.Sort;

//荷兰树问题
public class Code_08_NetherlandsFlag {
//    一个数组，一个数num。数组中小于num的在左边，等于num的在中间，大于num的在右边。时间复杂度O(N),空间复杂度O(1)


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 5, 6, 10, 67, 8, 9, 23, 42343, 345, 456};
        partiation(arr, 0, arr.length - 1, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     *
     * @param arr
     * @param l
     * @param r
     * @param num
     */
    private static void partiation(int[] arr, int l, int r, int num) {

//最开始是-1，最开始的less是不存在的。从-1开始。它代表从0到less的数值都小于等于num，
        //当遍历的时候遇到一个数小于 num。那么就让这个数和less的下一个数交换。然后让less向后移动一位
//假如第一个数就是小于num。此时less还是-1.那么就让这个数和-1的下一个数交换，也就是自己和自己交换
//        假如遇到的数都大于num。直到第三个数小于num了。那么久让第三个数和less的下一位也就是第0位数交换。

        int less = l - 1;
//        more和less一个意思。就是反过来
        int more = r + 1;
        int cur = l;//当前索引，从l开始，一直向右边遍历，直到cur>=more的时候结束遍历
        while (cur < more) {

            if (arr[cur] < num) {
//                让less 右移移动一位，然后和cur交换，然后cur在++。cur向右移动一位
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
