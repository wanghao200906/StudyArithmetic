package forOffer;

/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
是不是很简单？OK，搞定它！


思路："abc"复制为`abcabc` 。移动的n%length ，如果n大于lenght说明会向左移动好几圈，取余操作会避免移动好几圈的情况
使用substring来截取。移动n，此时最左边就是n了。所以从n开始截取。截取的长度也是n。
  */
public class Test_43_2 {
    public static String leftRotateString(String str, int count) {
        if (str == null && str.length() < count) {
            throw new RuntimeException("str is null or str length < count");
        }
        char[] data = str.toCharArray();
//        翻转三次
//        从count 左边翻转
        reverse(data, 0, count - 1);
//        count 右边翻转
        reverse(data, count, data.length - 1);
//        在整体翻转
        reverse(data, 0, data.length - 1);
        return new String(data);
    }

    public static void reverse(char[] data, int begin, int end) {
        if (data == null && data.length == 0) {
            return;
        }
        while (begin < end) {
            char temp = data[begin];
            data[begin] = data[end];
            data[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str="abcdefg ";

        String s = leftRotateString(str, 2);
        System.out.println(s);
    }


}
