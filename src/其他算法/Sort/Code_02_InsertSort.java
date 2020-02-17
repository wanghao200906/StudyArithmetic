package 其他算法.Sort;

public class Code_02_InsertSort {


    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 3, 5, 7, 8, 3, 2};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


    public static void sort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }

//        从1开始，是因为将1索引的数据和0比较。没必要从0开始让0与0比较
        for (int i = 1; i < arr.length; i++) {
// arr[j] > arr[j + 1] 是 右边的值比左边的值小，才会交换位置，
//            j--是，交换位置之后，要左移1位，继续进行arr[j] > arr[j + 1]  的比较
//            就是交换了之后，还要再看再往前是否还可以继续交换。
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
