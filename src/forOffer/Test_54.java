package forOffer;

/**
 * 题目：
 * <p>
 *  请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *  例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *  当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * <p>
 * <p>
 * 思路：
 * <p>
 * <p>
 * 为了尽可能高校地解决这个问题，需要在O(1)时间内往容器里插入一个字符，以及更新一个字符对应的值。
 * 这个容器可以用哈希表来实现。用字符的ASCII码作为哈希表的键值，而把字符对应的位置作为哈希表的值。
 */

public class Test_54 {

    public static char findFirstCharacter(String str) {
        if (str == null) {
            throw new RuntimeException("str is null");
        }
        int[] array = new int[256];
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            array[data[i]] += 1;
        }
        for (int i = 0; i < data.length; i++) {
            if (array[data[i]] == 1) {
                return data[i];
            }
        }
//        throw new RuntimeException("str can't find first character");
        return '#';
    }

    public static void main(String[] args) {
        String str = "";
        char firstCharacter = findFirstCharacter(str);
        System.out.println(firstCharacter);
    }

}

