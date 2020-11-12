/**
 * @Author: ybchen
 * @Date: 2020/11/12 14:47
 */
public class Code23MergeKLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     *给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     * @param lists
     * @return
     */


    public ListNode mergeKListsVer1(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i <lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }


    /**
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKListsVer2(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return merge(lists,0,lists.length-1);
    }

    public static ListNode merge(ListNode[] lists, int start, int end) {

        if (start <end) {
            int mid = start + (end - start) / 2;
            ListNode l1 = merge(lists, start, mid);
            ListNode l2 = merge(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        }else{
            return lists[start];
        }

    }


    /**
     * this Code is from No.21 Problem
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                return dummy.next;
            }
            if (l2 == null) {
                cur.next = l1;
                return dummy.next;
            }
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }




}
