package 算法的总结;

// 在字符串中找出第一个只出现一次的字符。
// 有效的字母异位词: s = "anagram", t = "nagaram"  s和t 就是一位字母，就是每个字符串的各个字母数量是一样的。顺序不一样

public class Hash {
    public static void main(String[] args) {
        Hash.printFirstLetter2("haaccb");
    }

    //    在字符串中找出第一个只出现一次的字符。
    public static void printFirstLetter2(String str) {
        char[] c = new char[256];
        for (int i = 0; i < str.length(); i++) {

            int c1 = str.charAt(i);
            c[c1]++;
        }
        for (int i = 0; i < str.length(); i++) {
            int temp=str.charAt(i);
            if(c[temp]==1){
                System.out.println((char)temp);
                break;
            }
        }
    }
//    有效的字母异位词
    public boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }

        char[] c=new char[26];
        for (int i = 0; i < s1.length(); i++) {
            c[s1.charAt(i)-'a']++;
            c[s2.charAt(i)-'a']--;
        }

        for (int c1 : c) {
            if(c1!=0){
                return false;
            }
        }
        return true;
    }
}
