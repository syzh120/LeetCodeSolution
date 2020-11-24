/**
 * @Author: ybchen
 * @Date: 2020/11/24 13:54
 */
public class Code1139Largest1BorderedSquare {

    /**
     * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
     * 示例 1：
     *
     * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：9
     * 示例 2：
     *
     * 输入：grid = [[1,1,0,0]]
     * 输出：1
     *  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-1-bordered-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */

    public static int largest1BorderedSquare(int[][] grid) {
        int[][] down = generateDownMatrix(grid);
        int[][] right = generateRightMatrix(grid);
        int i;
        for (i = grid.length; i > 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[j][k] == 0) {
                        continue;
                    }
                    if (down[j][k] >= i && right[j][k] >= i && right[j + i - 1][k] >= i && down[j][k + i - 1] >= i) {
                        return i * i;
                    }
                }
            }
        }
        return 0;
    }

    public static int[][] generateDownMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] matrix = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (i == row - 1) {
                    matrix[i][j] = grid[i][j];
                    continue;
                }
                matrix[i][j] = grid[i][j] == 0 ? 0 : matrix[i + 1][j] + 1;

            }
        }
        return matrix;
    }


    public static int[][] generateRightMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] matrix = new int[row][col];
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (i == col - 1) {
                    matrix[j][i] = grid[j][i];
                    continue;
                }
                matrix[j][i] = grid[j][i] == 0 ? 0 : matrix[j][i + 1] + 1;
            }
        }
        return matrix;
    }





}
