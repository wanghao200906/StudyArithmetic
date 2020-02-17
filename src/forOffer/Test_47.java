package forOffer;

/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Test_47 {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        //利用&&的短路特性
        //n=0的时候，停止递归，否则一直加
//        其实就是用与操作来进行if操作而已。
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }

}
