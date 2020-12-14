import java.util.*;

/**
 * @Author: ybchen
 * @Date: 2020/12/14 14:36
 */
public class Code49GroupAnagrams {

    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any
     * order.
     *
     * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
     * phrase, typically using all the original letters exactly once.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = str;
            str = sortStr(str);
            if (!map.containsKey(str)) {
                List<String> list = new ArrayList<>();
                map.put(str, list);
            }
            List<String> list = map.get(str);
            list.add(temp);
        }
        List<List<String>> result = new ArrayList<>(map.size());
        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public String sortStr(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}
