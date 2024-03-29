/**
 * @Author: ybchen
 * @Date: 2020/11/6 18:38
 */
public class Code11MaxArea {

    /**
     *  给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int L = 0;
        int R = height.length - 1;
        int maxArea = 0;
        while (L < R) {
            maxArea = Math.max((R - L) * Math.min(height[L], height[R]),maxArea);
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }

        return maxArea;
    }
}
