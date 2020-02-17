package forOffer;

/**
 * 题目：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复
 * 杂度是O(1)。
 * <p>
 * 举例说明
 * <p>
 * 例如输入数组｛2, 4, 3, 6, 3, 2, 5 }，因为只有4 、6 这两个数字只出现一次，其他数字都出现了两次，所以输出4和6 。
 * <p>
 * 思路：
 * 使用异或。 ^是异或运算符，异或的规则是转换成二进制比较，相同为0，不同为1.
 * <p>
 * a^a=0
 * a^0=a
 * a^b^c=a^(b^c)=(a^c)^b
 * <p>
 * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
 * 1）如果把数组中的所有数字都依次异或一遍，则可以消掉成对出现的数字，那么还有两个数字是单一的，肯定也不同，那么最终异或的结果肯定不是0。表示在二进制中肯定有一位是1，那么两个不同的数字，一定有一个在该位为1，另一个在该位为0。如果将整个数组按照该位是否为1分为两部分，那么这两部分各自包含一个单一数字。
 * <p>
 * 2）分为两部分的数组，分别异或，最终结果就是这两个数。
 */
public class Test_40 {

    public static void main(String[] args) {
        int[] arr = {5, 6};
        int[] numbersAppearanceOnce = findNumbersAppearanceOnce(arr);
        for (int i : numbersAppearanceOnce) {
            System.out.println(i);

        }


    }

    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] result = {0, 0};

        if (data == null || data.length < 2) {
            return result;
        }

        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }

//        xor的值是数组中没有的，因为是数组中 两个只出现一次的数 进行异或的结果
        int indexOf1 = findFirstBit1(xor);

        for (int i : data) {
            if (isBit1(i, indexOf1)) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }

        return result;
    }

    //    num转为二进制，从二进制数中找到 第一个1的那一位。
//    这个1怎么得到的？是数组中的两个不同的数进行异或操作，得到的。可以通过这个1来将数组分成两波，数组中肯定有一部分这一位是1，有一部分这一位是0
    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
//            如果和1与操作为0且小于32 说明这一位不是1，就向右移动一位。
            num >>>= 1;
            index++;
        }

        return index;
    }

    //判断num这一位是否是1，进行分组用的
    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }
}

