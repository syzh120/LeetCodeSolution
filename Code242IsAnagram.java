/**
 * @Author: ybchen
 * @Date: 2022/1/17 9:27
 */
public class Code242IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] judge = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            judge[index] = judge[index] + 1;
        }
        for (int j = 0; j < t.length(); j++) {
            int index = t.charAt(j) - 'a';
            judge[index] = judge[index] - 1;
        }
        for (int i = 0; i < 26; i++) {
            if (judge[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.print(isAnagram(s, t));
    }
}
