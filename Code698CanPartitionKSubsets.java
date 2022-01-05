/**
 * @Author: ybchen
 * @Date: 2021/10/14 18:04
 */
public class Code698CanPartitionKSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % k != 0 || nums.length < k) return false;
        int visited = 0;
        Boolean[] cache = new Boolean[1 << 17];
        return process(nums, k, visited, 0, sum / k, 0, cache);
    }


    public static boolean process(int[] nums, int desiredK, int visited, int currentK, int desiredTotal, int currentTotal, Boolean[] cache) {
        if (desiredK == currentK) {
            return true;
        }
        if (cache[visited] != null) return cache[visited];
        for (int i = 0; i < nums.length; i++) {
            if (((visited >> i) & 1) != 0 || currentTotal + nums[i] > desiredTotal) {
                continue;
            }

            if (currentTotal + nums[i] == desiredTotal) {
                if (process(nums, desiredK, visited | (1 << i), currentK + 1, desiredTotal, 0, cache)) {

                    cache[visited] = true;
                    return true;
                }
            } else {
                if (process(nums, desiredK, visited | (1 << i), currentK, desiredTotal, currentTotal + nums[i], cache)) {
                    cache[visited] = true;
                    return true;
                }
            }


        }

        cache[visited] = false;
        return false;
    }


    public static int power(int base, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * base;
        }
        return result;
    }

    public static int fib(int n) {
        double a = (1.0 + Math.sqrt(5)) / 2.0;
        double b = (1.0 - Math.sqrt(5)) / 2.0;
        double c = 1 / Math.sqrt(5);
        return (int) (c * (Math.pow(a, n) - Math.pow(b, n)));
    }


    public static int fastPower(int base, int n) {
        if (n == 0) return 1;
        int t = fastPower(base, n / 2);
        int result = t * t;
        if (n % 2 == 0) return result;
        return result * base;
    }

    public static void unitTest() {
        for (int x = 0; x < 20; x++) {
            for (int n = 0; n < 8; n++) {
                int r1 = power(x, n);
                int r2 = fastPower(x, n);
                if (r1 != r2) {
                    System.out.print("Oppps");
                    break;
                }
            }
        }
        System.out.print("Test passed");
    }


    public static void main(String[] args) {
        System.out.print(fib(5));
    }
}
