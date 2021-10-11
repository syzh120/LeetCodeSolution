//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: ybchen
// * @Date: 2021/5/7 17:29
// */
//public class TestMap {
//    public static boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
////        if (maxChoosableInteger >= desiredTotal) {
////            return true;
////        }
//        Map<String, Boolean> cache = new HashMap<>();
////        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
////            return false;
////        }
//        int[] state = new int[maxChoosableInteger + 1];
////        state[0] = 0;
////        state[1] = 1;
////        state[2]=1;
//        return process(maxChoosableInteger, desiredTotal, state, cache);
//    }
//
//    public static boolean process(int maxChoosableInteger, int desiredTotal, int[] state, Map<String, Boolean> cache) {
//
////        String key = Arrays.toString(state);
////        if (cache.containsKey(key)) {
////            return cache.get(key);
////        }
//        for (int num = 1; num < maxChoosableInteger + 1; num++) {
//            if (state[num] == 1) {
//                continue;
//            } else {
//                state[num] = 1;
//                if (desiredTotal - num <= 0) {
//                    state[num] = 0;
//                    return true;
//                }
//                if (!process(maxChoosableInteger, desiredTotal - num, state, cache)) {
//                    state[num] = 0;
////                    cache.put(key, true);
//                    return true;
//                }
//                state[num] = 0;
//            }
//        }
////        cache.put(key, false);
//        System.out.println("========");
//        return false;
//    }
//
//
//    public static void main(String[] args) {
////        for (int i = 1; i <= 5; i++) {
////            for (int j = 1; j <= 10; j++) {
////                if (canIWin1(i, j) != canIWin2(i, j)) {
////                    System.out.println(i);
////                    System.out.println(j);
////                    System.out.println("ooops failed");
////                    break;
////                }
////            }
////        }
//        System.out.println(canIWin1(3, 4));
//    }
//
//    //System.out.println(canIWin1(4, 6));
//}
//
