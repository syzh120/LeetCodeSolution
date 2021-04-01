import java.util.Stack;

/**
 * @Author: ybchen
 * @Date: 2021/3/31 16:56
 */
public class Code84LargestRectangleArea {
    /**
     * 维护一个递增的序列，这样可以很快看出其左边界的比他小的值。
     * 1.如果为空栈或者当前元素比栈顶元素大，则直接进栈。此时所有矩形面积均无法结算。
     * 2.当其小于等于时候栈顶元素之时。则弹出栈顶元素，弹出之时，结算以弹出的元素为高的矩形的宽度。
     * 此时其右边界为i,其左边界为其弹出之后的栈顶元素的下标j。result=（j-i-1）*height
     * a classic but complicated way
     *
     * @param heights
     * @return
     */

    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int toBeDem = stack.pop();
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, (right - left - 1) * heights[toBeDem]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int toBeDem = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            result = Math.max(result, (heights.length - left - 1) * heights[toBeDem]);
        }

        return result;
    }

    /**
     * a better and easy-understanding approach
     *
     * @param heights
     * @return
     */

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


}
