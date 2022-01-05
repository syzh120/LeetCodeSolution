import java.util.*;

/**
 * @Author: ybchen
 * @Date: 2021/12/30 14:55
 */
public class Code140WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = generateWordDictSet(wordDict);
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        process(result, s, set, path, 0);
        return result;

    }


    public static void process(List<String> result, String s, Set<String> wordSet, List<String> path, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(String.join(" ", path));
        }
        for (int splitIndex = startIndex; splitIndex < s.length(); splitIndex++) {
            String temp = s.substring(startIndex, splitIndex + 1);
            if (!wordSet.contains(temp)) {
                continue;
            } else {
                path.add(temp);
                process(result, s, wordSet, path, splitIndex + 1);
                path.remove(path.size() - 1);
            }

        }
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
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = wordBreak(s, wordDict);
        System.out.print(result);

    }
}
