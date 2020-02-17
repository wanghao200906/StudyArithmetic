package forOffer;

/**
 * 题目：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * <p>
 * 思路：
 * 第一种：直接求解：
 * <p>
 * 从头开始扫描这个字符串中的每个字符。当访问到某字符时拿这个字符和后面的每个字符相比较，如果在后面没有发现重复的字符，则该字符
 * 就是只出现一次的字符。如果字符串有n个字符，每个字符可能与后面的O(n）个字符相比较，因此这种思路的时间复杂度是O(n^2)。
 * <p>
 * 第二种：用类似哈希表的方式用来统计字符出现的次数。 时间复杂度O(n)
 * 第三种：直接用哈希表的方式用来统计字符出现的字数。时间复杂度O(n)
 */
public class Test_34 {

    public static void main(String[] args) {
        int haaccb = Test_34.FirstNotRepeatingChar("daccb");
        System.out.println(haaccb);

    }

    public static int FirstNotRepeatingChar(String str) {
        char[] c = new char[256];
        for (int i = 0; i < str.length(); i++) {
            c[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (c[str.charAt(i)] == 1) {
                return i;
            }

        }
        return -1;
    }
}

