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

public class Test_44 {

    public static void main(String[] args) {
        String str = "I am a student.";
        String s=ReverseSentence(str);
        System.out.println(s);

    }

    public static String ReverseSentence(String str) {
        if(str.trim().length() <= 0){
            return str;
        }

        String[] strArr = str.split(" ");

        String res = "";

        for(int i=strArr.length-1;i>=0;i--){
            if(i != 0){
                res += strArr[i] + " ";
            }else{
                res += strArr[i];
            }
        }

        return res;
    }
}

