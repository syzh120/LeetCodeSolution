import java.util.Stack;

/**
 * @Author: ybchen
 * @Date: 2021/3/31 14:48
 */
public class Code739DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        int[] result = new int[T.length];
        reverseArr(T);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            result[T.length - 1 - i] = stack.isEmpty() ? 0 : i - stack.peek();
            stack.push(i);
        }
        return result;
    }


    public void reverseArr(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            swap(arr, startIndex++, endIndex--);
        }
    }

    public void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;

    }

}
