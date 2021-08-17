import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ybchen
 * @Date: 2021/8/16 15:38
 */
public class Code139WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = generateWordDictSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * wordList->wordSet make query in O(1)
     *
     * @param wordDict
     * @return
     */
    public static Set<String> generateWordDictSet(List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        return wordSet;
    }

    public static void main(String[] args) {
        //
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        List<String> list = Arrays.asList(wordDict);
        System.out.println(wordBreak(s, list));
    }
}
