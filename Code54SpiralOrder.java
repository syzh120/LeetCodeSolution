import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/23 14:18
 */
public class Code54SpiralOrder {

    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * Example 1:
     * <p>Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int sR = 0;
        int eR = row;
        int sC = 0;
        int eC = col;
        while (sR <= eR && sC <= eC) {
            process(matrix, sR++, eR--, sC++, eC--, result);
        }

        return result;

    }

    public static void process(int[][] matrix, int sR, int eR, int sC, int eC, List<Integer> result) {

        for (int i = sC; i <= eC; i++) {
            result.add(matrix[sR][i]);
        }
        if (sR == eR) return;
        for (int i = sR + 1; i <= eR; i++) {
            result.add(matrix[i][eC]);
        }
        if (sC == eC) return;
        for (int i = eC - 1; i >= sC; i--) {
            result.add(matrix[eR][i]);
        }
        for (int i = eR - 1; i >= sR + 1; i--) {
            result.add(matrix[i][sC]);
        }
    }
}
