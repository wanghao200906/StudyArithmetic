package forOffer;

/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
是不是很简单？OK，搞定它！


思路："abc"复制为`abcabc` 。移动的n%length ，如果n大于lenght说明会向左移动好几圈，取余操作会避免移动好几圈的情况
使用substring来截取。移动n，此时最左边就是n了。所以从n开始截取。截取的长度也是n。
  */
public class Test_43 {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() <= 0){
            return "";
        }
        //复制字符串，比如"abc"复制为`abcabc`
        String s = str + str;
        int len = str.length();
        //算出偏移量
        n = n%len;
        //开始从n截取，截取到len+n
        return s.substring(n,len+n);
    }

}
