import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/11 9:11
 */
public class CuttingRopes {

    public static int cuttingRope(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return process(n, cache);
    }


    public static int process(int leftLength, int[] cache) {
        if (leftLength == 1) return 1;
        if (cache[leftLength] != -1) return cache[leftLength];
        int result = 0;
        for (int i = 1; i < leftLength; i++) {
            result = Math.max(result, i * process(leftLength - i, cache));
        }
        cache[leftLength] = result;
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print(cuttingRope(n));
    }
}
