/**
 * @Author: ybchen @Date: 2020/12/17 16:38
 */
public class Code70ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the
     * top?
     */
    public static int climbStairs(int n) {
        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] answer = fastPow4Matrix(matrix, n - 2);
        return 2 * answer[0][0] + answer[1][0];
    }

    /**
     * 快速求解矩阵的N次幂
     *
     * @param matrix
     * @param n
     * @return
     */

    public static int[][] fastPow4Matrix(int[][] matrix, int n) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int[][] x = matrix;
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                result = matrixMultiply(result, x);
            }
            x = matrixMultiply(x, x);
            n = n / 2;
        }
        return result;
    }

    /**
     * 方阵的乘法
     *
     * @param
     * @return
     */

    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] resultMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int result = 0;
                for (int k = 0; k < col; k++) {
                    result = result + matrix1[i][k] * matrix2[k][j];
                }
                resultMatrix[i][j] = result;
            }
        }
        return resultMatrix;

    }


}
