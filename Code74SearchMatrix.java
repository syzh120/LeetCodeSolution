/**
 * @Author: ybchen
 * @Date: 2020/12/17 15:36
 */
public class Code74SearchMatrix {

    /**
     * @param matrix
     * @param target
     * @return @Description Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     * <p>Integers in each row are sorted from left to right. The first integer of each row is
     * greater than the last integer of the previous row
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        int startRow = 0;
        int startCol = totalCol - 1;
        while (startRow < totalRow && startCol > -1) {
            if (matrix[startRow][startCol] == target) {
                return true;
            } else if (matrix[startRow][startCol] < target) {
                startRow++;
            } else {
                startCol--;
            }
        }

        return false;
    }
}
