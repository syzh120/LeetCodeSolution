/**
 * @Author: ybchen
 * @Date: 2022/1/4 17:16
 */
public class Code583MinDistance {

    public static int minDistance(String word1, String word2) {
        return process(word1, word2, 0, 0);
    }

    public static int process(String word1, String word2, int index1, int index2) {
        return 0;
    }

    public static void main(String[] args) {
        String word1 = "ae";
        String word2 = "a";
        System.out.print(minDistance(word1, word2));
    }
}
