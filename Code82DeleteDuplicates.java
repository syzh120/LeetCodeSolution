/**
 * @Author: ybchen
 * @Date: 2021/5/24 14:45
 */
public class Code82DeleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = head;
        ListNode right = left.next;
        ListNode pre = dummy;
        while (right != null) {
            boolean flag = false;
            while (right != null && right.val == left.val) {
                right = right.next;
                flag = true;
            }
            if (!flag) {
                pre = left;
            } else {
                pre.next = right;
            }
            left = right;
            right = right == null ? null : right.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        //
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode head2 = deleteDuplicates(head);
        ListNode cur = head2;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }


    }
}
