import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/12/30 16:29
 */
public class Code221MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int[][] cache = new int[matrix.length + 1][matrix[0].length + 1];
        for (int row = 0; row < matrix.length + 1; row++) {
            Arrays.fill(cache[row], -1);
        }
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int res = process(matrix, i, j, cache);
                ans = Math.max(ans, res);
            }
        }
        return ans * ans;
    }

    public int process(char[][] matrix, int startRow, int startCol, int[][] cache) {
        if (startRow >= matrix.length
                || startCol >= matrix[0].length
                || matrix[startRow][startCol] == '0') return 0;
        if (cache[startRow][startCol] != -1) return cache[startRow][startCol];
        int right = process(matrix, startRow, startCol + 1, cache);
        int down = process(matrix, startRow + 1, startCol, cache);
        int dig = process(matrix, startRow + 1, startCol + 1, cache);
        cache[startRow][startCol] = Math.min(Math.min(right, down), dig) + 1;
        return cache[startRow][startCol];
    }
}
