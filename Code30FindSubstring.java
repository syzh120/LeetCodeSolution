import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ybchen
 * @Date: 2020/11/25 16:55
 */
public class Code30FindSubstring {
    /**
     *
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     * 示例 1：
     *
     * 输入：
     *   s = "barfoothefoobarman",
     *   words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     *
     * 输入：
     *   s = "wordgoodgoodgoodbestword",
     *   words = ["word","good","best","word"]
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param words
     * @return
     */

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordFreMap = getWordFreMap(words);
        for (int start = 0; start < s.length()-words.length*words[0].length()+1; start++) {
            if(isValidConcat(s,words,wordFreMap,start)){
                result.add(start);
            }
        }
        return result;
    }

    public static boolean isValidConcat(String s, String[] words, Map<String, Integer> wordFreMap, int start) {
        Map<String, Integer> candidateMap = new HashMap<>();
        int j;
        for (j = 0; j < words.length; j++) {
            String temp = s.substring(start + j * words[0].length(), start + (j + 1) * words[0].length());
            candidateMap.put(temp, candidateMap.getOrDefault(temp, 0) + 1);
            if (!wordFreMap.containsKey(temp)||candidateMap.get(temp) > wordFreMap.get(temp)) {
                return false;
            }

        }
        return true;

    }




    public static Map<String, Integer> getWordFreMap(String[] words) {
        Map<String, Integer> wordFreMap = new HashMap<>();
        for (String word : words) {
            wordFreMap.put(word, wordFreMap.getOrDefault(word, 0) + 1);
        }

        return wordFreMap;

    }


}
