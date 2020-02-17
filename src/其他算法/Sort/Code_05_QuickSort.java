package 其他算法.Sort;

public class Code_05_QuickSort {
    public static void main(String[] args) {

        int[] arr = {1 ,3 ,5 ,4, 2};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr, int l, int r) {

        if (l < r) {
            int[] p = partition(arr, l, r);
            sort(arr, l, p[0] - 1);
            sort(arr, p[1] + 1, r);
        }
    }


//    让所有的数都和数组的最后一个数进行对比
    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int cur = l;
        //more处的值一直都大于比较值，这里也就是大于arr[r]

        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
//       在while的遍历中 arr最后一个值作为比较的对象，位置不会改变。直到最后遍历结束了。
// more的位置肯定是大于 比较值。所以需要调换位置。
        //让第一个大于比较值的值，和arr[r]交换，这样中间是和arr[r]相同的了。
        swap(arr, more, r);
//        返回了等于区域的下标
//        之所以返回两个值，是因为 less+1 和 more之间的数据是相等的。 是相等几个数据的最左右两边的索引。
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
