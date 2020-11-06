/**
 * @Author: ybchen
 * @Date: 2020/11/5 19:30
 */
public class Code04FindMedianSortedArrays {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     *
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int start = 0;
        int end = nums1.length;
        int totalLength=nums1.length+ nums2.length;
        while (true) {
            int X = start + (end - start) / 2;//x-1 is the index
            int Y = (totalLength + 1) / 2 - X;
            int XLeftMax = X <= 0 ? Integer.MIN_VALUE : nums1[X - 1];
            int XRightMin = X >=nums1.length ? Integer.MAX_VALUE : nums1[X];
            int YLeftMax = Y <= 0 ? Integer.MIN_VALUE : nums2[Y - 1];
            int YRightMin = Y >= nums2.length ? Integer.MAX_VALUE : nums2[Y];
            if (XLeftMax <= YRightMin && YLeftMax <= XRightMin) {
                if ((totalLength & 1) == 0) {
                    return (Math.max(XLeftMax, YLeftMax) + Math.min(XRightMin, YRightMin)) / 2.0;
                } else {
                    return Math.max(XLeftMax, YLeftMax);
                }
            } else if (XLeftMax > YRightMin) {
                end = X - 1;
            } else {
                start = X + 1;
            }

        }
    }


}
