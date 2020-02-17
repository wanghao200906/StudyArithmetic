package forOffer;

/**
 * 题目：
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * <p>
 * 举例说明
 * <p>
 * 例如输入字符串”I am a student. ”，则输出”student. a am I”。
 * 思路：
 * <p>
 * 第一步翻转句子中所有的字符。比如翻转“I am a student. ”中所有的字符得到”.tneduts a ma I”.
 * 此时不但翻转了句子中单词的顺序，连单词内的字符顺序也被翻转了。
 * 第二步再翻转每个单词中字符的顺序，就得到了”student. a am I”。这正是符合题目要求的输出。
 */

public class Test_44_2 {
    public static void wordResverse(String str) {
        if (str == null) {
            throw new RuntimeException("str is null");
        }
        char[] data = str.toCharArray();
//整体翻转
        reverse(data, 0, data.length - 1);
        System.out.println(new String(data));
        int begin = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == ' ') {
//                以空格为界限进行翻转
                reverse(data, begin, i - 1);
                begin = i+1;
            }
        }
        System.out.println(new String(data));
    }

    /**
     * 首尾颠倒
     *
     * @param data
     * @param begin
     * @param end
     */
    public static void reverse(char[] data, int begin, int end) {
        if (data == null) {
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

        String str = "i am a boy!";
        wordResverse(str);

    }
}

