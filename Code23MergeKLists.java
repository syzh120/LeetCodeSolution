import java.util.Comparator;
import java.util.PriorityQueue;

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

     //版本1
    public ListNode mergeKListsVer1(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i <lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }


    ////版本2
    public static ListNode mergeKListsVer2(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return merge(lists,0,lists.length-1);
    }




    //版本3
    public ListNode mergeKListsVer3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ComposeType> minPQ = new PriorityQueue<>(new ValueAscendingComparator());
        for (ListNode node : lists) {
            if (node == null) continue;
            minPQ.add(new ComposeType(node.val, node));
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minPQ.isEmpty()) {
            ComposeType ct = minPQ.poll();
            ListNode node = ct.node;
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                minPQ.add(new ComposeType(node.next.val, node.next));
            }
        }
        return dummy.next;
    }





    private static ListNode merge(ListNode[] lists, int start, int end) {

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

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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



    public class ComposeType {
        int val;
        ListNode node;

        public ComposeType(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }

    public class ValueAscendingComparator implements Comparator<ComposeType> {

        @Override
        public int compare(ComposeType o1, ComposeType o2) {
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes ={};
        Code23MergeKLists code=new Code23MergeKLists();
        code.mergeKListsVer3(listNodes);
    }















}
