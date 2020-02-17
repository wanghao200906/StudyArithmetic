package forLeetcode.leetcode_0049_group_anagrams;

//  49
/// https://leetcode-cn.com/problems/group-anagrams/


/*
字母异位词分组

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {};

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (hash.containsKey(key)) {
                hash.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hash.put(key, list);
            }
        }

        return new ArrayList<>(hash.values());


    }

}