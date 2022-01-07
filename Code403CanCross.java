/**
 * @Author: ybchen
 * @Date: 2022/1/6 15:38
 */
public class Code403CanCross {
    public static boolean canCross(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][stones.length - 1];
        return process(stones, 0, 0, dp);
    }

    public static boolean process(int[] stones, int startIndex, int preStep, Boolean[][] dp) {
        if (startIndex == stones.length - 1) return true;
        if (dp[startIndex][preStep] != null) return dp[startIndex][preStep];
        boolean flag = false;
        for (int step = preStep - 1; step <= preStep + 1; step++) {
            if (step == 0) continue;
            int nextIndex = nextJumpIndex(stones, startIndex, step);
            if (nextIndex == -1) continue;
            if (process(stones, nextIndex, step, dp)) {
                dp[startIndex][preStep] = true;
                return true;
            }

        }
        dp[startIndex][preStep] = flag;
        return flag;
    }

    /**
     * 给你一个当前位置以及下一步跳跃的步数，请给我下一步的落点的位置
     * 待优化成二分查找
     *
     * @param stones
     * @param startIndex
     * @param step
     * @return
     */
    public static int nextJumpIndex(int[] stones, int startIndex, int step) {
        int nextIndex;
        int maxIndex = Math.min(stones.length, startIndex + step + 1);
        for (nextIndex = startIndex + 1; nextIndex < maxIndex; nextIndex++) {
            if (stones[nextIndex] - stones[startIndex] == step) {
                return nextIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stone1 = {0, 1, 2, 3, 4, 8};
        int[] stone2 = {0, 1, 2, 3, 5, 6, 8, 10, 11};
        System.out.println(canCross(stone2));
    }
}
