package forLeetcode.leetcode_0451_sort_characters_by_frequency;

/// Leetcode 451
/// https://leetcode-cn.com/problems/sort-characters-by-frequency/


/*

根据字符出现频率排序


给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

 */

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));

    }

    public static String frequencySort(String s) {
        int[] hash = new int[256];
        StringBuilder sb = new StringBuilder();
//        数组中以 char为索引。数组的值就是每个char出现的频率。
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        int[] hash1 = hash.clone();//这个数组是为了找到hash数组排序后对应的下标
        Arrays.sort(hash);//将数组排序 排序后，数组前面全是0，想要的元素都在最后面
        for (int i = 255; i > 0 && hash[i] > 0; i--) {//为0的部分直接不用管
            for (int j = 0; j < 256; j++) {   //从未排序的里面找到对应值
                if (hash[i] == hash1[j]) {
                    while (hash1[j]-- > 0)
                        sb.append((char) j);
                }
            }
        }
        return sb.toString();
    }

}
