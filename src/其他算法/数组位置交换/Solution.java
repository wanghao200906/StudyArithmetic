package 其他算法.数组位置交换;


//有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变，要求时间复杂度为O(n), 空间复杂度为O(1)。例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35}变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}。
public class Solution {


    public static void main(String[] args) {
        int[] a={10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
        setParted1(a,0,a.length-1);

    }
    public static void setParted1(int[] a, int left, int right) {
        if (left >= right || left == a.length || right == 0) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            return;
        }
        while (a[left] < 0) {
            left++;
        }
        while (a[right] >= 0) {
            right--;
        }
        if (left >= right || left == a.length || right == 0) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            return;
        }
        swap(a, left, right);
        left++;
        right--;
        setParted1(a, left, right);
    }

    private static void swap(int a[], int left, int right) {
        int temp = 0;
        temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }


}
