/**
 * @Author: ybchen
 * @Date: 2021/10/12 12:39
 */
public class TestRunner {

    public static int[][] randomMatrix() {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int rd = Math.random() > 0.5 ? 1 : 0;
                matrix[i][j] = rd;
            }
        }
        return matrix;
    }

    public static boolean isSameArr(int[][] matrix1, int[][] matirx2) {
        for (int i = 0; i < matirx2.length; i++) {
            for (int j = 0; j < matirx2[0].length; j++) {
                if (matirx2[i][j] != matrix1[i][j]) return false;
            }

        }
        return true;
    }

    public static int[][] copyMat(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }

    public static void printArr(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println("=====");
        }
    }

    public static boolean isValidCase(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[][] matrix = randomMatrix();
            if (!isValidCase(matrix)) continue;
            int[][] copy = copyMat(matrix);
            int[][] ans1 = Code_UpdateMatrix.updateMatrix(matrix);
            int[][] ans2 = Code_UpdateMatrix.updateMatrix2(copy);
            if (!isSameArr(ans1, ans2)) {
                printArr(matrix);
                System.out.print("oops");
                return;
            }
        }

        System.out.print("passed test");
    }
}
