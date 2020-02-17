package forOffer;

/**
 * 题目：
 * <p>
 * 给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],
 * 其中B中的元素B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法。
 * 思路：
 */

public class Test_51 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int[] multiply = multiply(arr);
        for (double v : multiply) {
            System.out.println(v);
        }
    }


    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = multiplyA(A, i);
        }
        return B;
    }

    public static int multiplyA(int[] A, int i) {
        int mul = 1;
        for (int j = 0; j < i; j++) {
            mul *= A[j];
        }
        for (int k = i + 1; k < A.length; k++) {
            mul *= A[k];
        }
        return mul;
    }


}

