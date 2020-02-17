package forOffer;

/**
 * 题目：
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
 * <p>
 * 思路：
 * 先判断字符串中空格的数量。根据数量判断该字符串有没有足够的空间替换成"%20"。
 * 如果有足够空间，计算出需要的空间。根据最终需要的总空间，维护一个指针在最后。
 * 从后到前，遇到非空的就把该值挪到指针指向的位置，然后指针向前一位，遇到“ ”，则指针前移，依次替换为“%20”。
 */
public class Test_02 {

    public static void main(String[] args) {
        String str = "We are happy.";

        System.out.println(cover(new String("We are happy.")));
    }

    private static String cover(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int oldLength = 0, blankNum = 0;

        while (oldLength < str.length()) {

            if (str.charAt(oldLength) == ' ') {
                blankNum++;
            }
            oldLength++;
        }

        int newLength = oldLength + 2 * blankNum;

        int oleIndex = oldLength - 1, newIndex = newLength - 1;
        char[] newContent = new char[newLength];

        while (oleIndex >= 0) {
            if (str.charAt(oleIndex) == ' ') {
                newContent[newIndex--] = '0';
                newContent[newIndex--] = '2';
                newContent[newIndex--] = '%';
            } else {
                newContent[newIndex--] = str.charAt(oleIndex);
            }
            oleIndex--;
        }
        return new  String(newContent);
    }

}
