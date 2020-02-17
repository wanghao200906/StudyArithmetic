package 算法的总结;



public class Sort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};

//        sortBubble(arr);
//        sortMerge(arr);
        sortQuick(arr);
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    //冒泡排序。就是每次遍历都比之前的少一个。
    public static void sortBubble(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

//
    public static void sortInsert(int[] arr) {
      if(arr==null||arr.length<1){
          return;
      }

      for(int i=1;i<arr.length;i++){
          for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
              swap(arr,j,j+1);
          }
      }
    }


    //    nlogn
    public static void sortMerge(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortMergeProcess(arr, 0, arr.length - 1);

    }

    private static void sortMergeProcess(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        sortMergeProcess(arr, start, mid);
        sortMergeProcess(arr, mid + 1, end);
        sortMerge(arr, start, mid, end);
    }

    private static void sortMerge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;
        int p1 = start;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] < arr[p2]) {
                temp[i++] = arr[p1++];
            } else {
                temp[i++] = arr[p2++];
            }
        }
//注意是while不是if
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= end) {
            temp[i++] = arr[p2++];
        }

//        把temp中的值赋值给arr数组。
        for (int j = 0; j < temp.length; j++) {
            arr[start + j] = temp[j];
        }

    }


    public void sortSelect(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            swap(arr, i, min);
        }
    }


    public static void sortQuick(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortQuick(arr, 0, arr.length - 1);
    }
    private static void sortQuick(int[] arr, int l, int r) {

        if (l < r) {
            int[] p = paration(arr, l, r);
            sortQuick(arr, l, p[0] - 1);
            sortQuick(arr, p[1] + 1, r);
        }
    }
    private static int[] paration(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}

// 冒泡排序： 外层for是从 end开始，然后end--，内层for是从0开始 到end。两两比较交换，最大值放在内存换的最后面，每次内循环结束，下一次都会少一位
// 选择排序： 外层for,i=0开始，内层for从 i+1开始。 设置一个min变量，内层for完事儿，min是最小值。然后让i和min交换。这样i永远都是最小值了
// 归并排序：去中间点，一部分是从start 到mid，一部分是从mid+1 到end。递归。 合并是 将  从start 到mid 和 从mid+1 到end 这两部分每次各取一个数，然后将最小的放到缓存数组中。最后在将缓存数组 一一放到arr数组中
// 插入排序：外层for,i=1开始。内层j=i-1开始。 当j>=0&&arr[j]>arr[j+1]就交换。然后j--.当不满足条件退出内层循环。其实就是将外层循环i对应的值向插入。
//




