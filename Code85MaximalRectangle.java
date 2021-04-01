/**
 * @Author: ybchen
 * @Date: 2021/4/1 9:52
 */
public class Code85MaximalRectangle {


    public static int maximalRectangle(char[][] matrix) {
        int result = 0;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int[] height = new int[matrix[0].length];
        for (int level = 0; level < matrix.length; level++) {
            for (int col = 0; col < matrix[0].length; col++) {
                height[col] = matrix[level][col] == '1' ? height[col] + 1 : 0;
            }
            result = Math.max(result, largestRectangleArea(height));
        }

        return result;
    }

    public static int largestRectangleArea(int[] heights) {
        int result = 0;
        int[] leftLess = new int[heights.length];
        int[] rightLess = new int[heights.length];
        leftLess[0] = -1;
        rightLess[heights.length - 1] = heights.length;
        for (int i = 1; i < leftLess.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftLess[p];
            }
            leftLess[i] = p;

        }
        for (int i = rightLess.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < rightLess.length && heights[p] >= heights[i]) {
                p = rightLess[p];
            }
            rightLess[i] = p;

        }
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (rightLess[i] - leftLess[i] - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
