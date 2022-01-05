/**
 * @Author: ybchen
 * @Date: 2021/12/31 10:11
 */
public class Code474FindMaxForm {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] cache = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i < strs.length + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    cache[i][j][k] = -2;
                }
            }

        }
        return process(strs, m, n, 0, cache);
    }

    /**
     * 统计字符串中0的个数
     *
     * @param str
     * @return
     */
    public static int numbersOf0(String str) {
        char[] chs = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '0') count++;
        }
        return count;
    }

    public static int process(String[] strs, int m, int n, int startIndex, int[][][] cache) {
        if (m < 0 || n < 0) return -1;
        if (startIndex >= strs.length) return 0;
        if (cache[startIndex][m][n] != -2) return cache[startIndex][m][n];
        String str = strs[startIndex];
        int num0 = numbersOf0(str);
        int num1 = str.length() - num0;
        int include = process(strs, m - num0, n - num1, startIndex + 1, cache);
        int exclude = process(strs, m, n, startIndex + 1, cache);
        if (include != -1 && exclude != -1) {
            cache[startIndex][m][n] = Math.max(include + 1, exclude);
        } else {
            if (include == -1) cache[startIndex][m][n] = exclude;
            if (exclude == -1) cache[startIndex][m][n] = include == -1 ? -1 : include + 1;
        }
        return cache[startIndex][m][n];

    }

    public static void main(String[] args) {
        String[] strs = {"00", "000"};
        int m = 1, n = 10;
        System.out.print(findMaxForm(strs, m, n));
    }
}
