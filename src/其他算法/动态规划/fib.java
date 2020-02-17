package 其他算法.动态规划;


//动态规划：将一个问题分成若干个子问题，保存每个子问题的结果。使得每个子问题只求解一次，最终获得答案。
//动态规划的斐波那契
public class fib {


    public int fib(int n) {
        int[] num = new int[n + 1];

        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[n] = num[n - 1] + num[n - 2];
        }

        return num[n];

    }
}
