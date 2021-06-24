/**
 * @Author: ybchen
 * @Date: 2021/6/22 10:35
 */
public class Code160IntersectionNodeProblem {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        return null;
    }


    public int getListLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length = length + 1;
            cur = cur.next;
        }
        return length;
    }
}
