package 其他算法.Sort;

public class Code_03_MergeSort {

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

        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l+ (r-l)/2;

        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);

        merge(arr, l, mid, r);


    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] arrTmp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {

            if (arr[p1] < arr[p2]) {
                arrTmp[i++] = arr[p1++];
            } else {
                arrTmp[i++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            arrTmp[i++] = arr[p1++];

        }
        while (p2 <= r) {
            arrTmp[i++] = arr[p2++];
        }


        for (int j = 0; j < arrTmp.length; j++) {
            arr[l + j] = arrTmp[j];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
