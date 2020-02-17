package 其他算法.Sort;

public class Code_04_SelectSort {

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
        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
