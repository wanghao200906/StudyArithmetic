package forOffer;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

解法https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387

a[n]=a[n-1]+a[n-2]+......+a[1];..........................①
a[n-1]=        a[n-2]+......+a[1];..........................②
两式相减可知：a[n]=2*a[n-1];
 */
public class Test_09 {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }


    }
}
