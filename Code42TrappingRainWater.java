/**
 * @Author: ybchen
 * @Date: 2020/12/4 12:10
 */
public class Code42TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int L = 0;
        int R = height.length - 1;
        int leftMax = height[L];
        int rightMax = height[R];
        int sum = 0;
        while (L <= R) {
            if (leftMax <= rightMax) {
                sum = sum + Math.max(0, leftMax - height[L]);
                leftMax = Math.max(leftMax, height[L++]);
            } else {
                sum = sum + Math.max(0, rightMax - height[R]);
                rightMax = Math.max(rightMax, height[R--]);

            }
        }
        return sum;
    }

}
