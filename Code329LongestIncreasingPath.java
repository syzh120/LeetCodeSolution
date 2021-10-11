/**
 * @Author: ybchen
 * @Date: 2021/10/8 10:14
 */
public class Code329LongestIncreasingPath {
    static int[] dx = {-1, +1, 0, 0};
    static int[] dy = {0, 0, +1, -1};

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxLen = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLen = Math.max(maxLen, process(matrix, i, j, cache));
            }
        }
        return maxLen;
    }


    public static int process(int[][] matrix, int row, int col, int[][] cache) {

        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        int maxLen = 1;//默认初始值为1;
        for (int i = 0; i < dx.length; i++) {
            int nextX = row + dx[i];
            int nextY = col + dy[i];
            if (isValidPlace(matrix, nextX, nextY) && matrix[nextX][nextY] > matrix[row][col]) {
                maxLen = Math.max(maxLen, process(matrix, nextX, nextY, cache) + 1);
            }

        }

        cache[row][col] = maxLen;
        return maxLen;

    }

    public static boolean isValidPlace(int[][] matrix, int row, int col) {
        return !(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length);
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(longestIncreasingPath(matrix));

    }
}
