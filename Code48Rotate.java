/**
 * @Author: ybchen
 * @Date: 2020/12/15 10:12
 */
public class Code48Rotate {

    /**
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees
     * (clockwise).
     *
     * <p>You have to rotate the image in-place, which means you have to modify the input 2D matrix
     * directly. DO NOT allocate another 2D matrix and do the rotation.
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int sR = 0;
        int sC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        while (sR < eR) {
            rotate(matrix, sR++, eR--, sC++, eC--);
        }


    }

    public static void rotate(int[][] matrix, int sR, int eR, int sC, int eC) {
        int times = eR - sR;
        for (int i = 0; i < times; i++) {
            int temp = matrix[sR][sC + i];
            matrix[sR][sC + i] = matrix[eR - i][sC];
            matrix[eR - i][sC] = matrix[eR][eC - i];
            matrix[eR][eC - i] = matrix[sR + i][eC];
            matrix[sR + i][eC] = temp;
        }
    }
}
