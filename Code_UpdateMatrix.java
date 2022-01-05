import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ybchen
 * @Date: 2021/10/12 9:10
 */
public class Code_UpdateMatrix {
    static int[] dx = {-1, +1, 0, 0};
    static int[] dy = {0, 0, +1, -1};

    public static int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] answer = new int[row][col];
        int[][] cache = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(cache[i], -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer[i][j] = process(mat, i, j, cache, visited);
            }

        }
        return answer;
    }


    static int process(int[][] matrix, int curRow, int curCol, int[][] cache, boolean[][] visited) {
        if (!isValidPlace(matrix, curRow, curCol) || visited[curRow][curCol])
            return Integer.MAX_VALUE - 1;
        if (matrix[curRow][curCol] == 0) return 0;
        if (cache[curRow][curCol] != -1 && cache[curRow][curCol] < Integer.MAX_VALUE - 1)
            return cache[curRow][curCol];
        int res = Integer.MAX_VALUE - 1;
        visited[curRow][curCol] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = dx[i] + curRow;
            int nextCol = dy[i] + curCol;
            res = Math.min(1 + process(matrix, nextRow, nextCol, cache, visited), res);
        }
        visited[curRow][curCol] = false;
        cache[curRow][curCol] = res;
        return res;

    }

    static boolean isValidCache(int[][] matrix, int curRow, int curCol) {
        for (int i = 0; i < 4; i++) {
            int nextX = curRow + dx[i];
            int nextY = curCol + dy[i];
            if (isValidPlace(matrix, nextX, nextY) && matrix[nextX][nextY] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidPlace(int[][] matrix, int curRow, int curCol) {
        return !(curRow < 0 || curCol < 0 || curRow >= matrix.length || curCol >= matrix[0].length);
    }


    public static int[][] updateMatrix2(int[][] matrix) {
        int len1 = matrix.length;
        if (len1 == 0) {
            return new int[0][0];
        }
        int len2 = matrix[0].length;
        //使用一个队列来存储访问过的坐标
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                //如果该元素为0，则加入队列中
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else//否则将该坐标的值设为一个不可能达到的数
                {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //四个方向
        int[][] dire = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (queue.size() != 0) {
            int[] temp = queue.poll();
            for (int a = 0; a < 4; a++) {
                int x = temp[0] + dire[a][0];
                int y = temp[1] + dire[a][1];
                //如果新坐标的值大于当前坐标的值加一，那么说明从本结点出发距离更近，则修改新坐标的值，并将新坐标加入队列中
                if (x >= 0 && y >= 0 && x < len1 && y < len2 && matrix[x][y] > matrix[temp[0]][temp[1]] + 1) {
                    matrix[x][y] = matrix[temp[0]][temp[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        //int[][] mat = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        //int[][] mat = {{0, 0, 1, 1}};
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = updateMatrix(mat);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(ans[i][j]);
            }
            System.out.println("=====");
        }
    }


}
