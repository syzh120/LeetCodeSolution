/**
 * @Author: ybchen
 * @Date: 2021/5/25 9:32
 */
public class Code83DeleteDuplicates {

    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            while (right != null && right.val == left.val) {
                right = right.next;
            }
            left.next = right;
            left = right;
            right = right == null ? null : right.next;

        }
        return head;
    }
}
