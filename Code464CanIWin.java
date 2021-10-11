/**
 * @Author: ybchen
 * @Date: 2021/10/8 12:34
 */
public class Code464CanIWin {

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        Boolean[] cache = new Boolean[1 << 21];
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return process(maxChoosableInteger, desiredTotal, 0, cache);
    }

    public static boolean process(int maxChoosableInteger, int desiredTotal, int state, Boolean[] cache) {
        Integer key = state;
        if (cache[key] != null) {
            return cache[key];
        }
        if (desiredTotal <= 0) return false;
        for (int num = 1; num < maxChoosableInteger + 1; num++) {
            if (((state >> num) & (1)) != 0) {
                continue;
            } else {
                if (!process(maxChoosableInteger, desiredTotal - num, state | (1 << num), cache)) {
                    cache[key] = true;
                    return true;
                }

            }
        }
        cache[key] = false;
        return false;
    }

    public static void main(String[] args) {
        //        for (int i = 1; i <= 10; i++) {
        //            for (int j = 1; j <= 20; j++) {
        //                if (canIWin1(i, j) != canIWin2(i, j)) {
        //                    System.out.println(i);
        //                    System.out.println(j);
        //                    System.out.println("ooops failed");
        //                    break;
        //                }
        //            }
        //        }
        //        System.out.println("Test passed");
        //    }

        System.out.println(canIWin(3, 4));
        //    }
    }
}
