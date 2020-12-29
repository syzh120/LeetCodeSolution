/**
 * @Author: ybchen
 * @Date: 2020/12/29 15:14
 */
public class Code61RotateList {


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

    // TODO: 2020/12/29 优化为O(N)的解法

    /**
     * Given the head of a linked list, rotate the list to the right by k places.
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        k = k % getListLength(head);
        for (int i = 0; i < k; i++) {
            head = moveLastToHead(head);
        }
        return head;
    }


    public static ListNode moveLastToHead(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null && cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        cur.next = head;
        return cur;
    }

    public static int getListLength(ListNode head) {
        ListNode cur = head;
        int length = 1;
        while (cur != null && cur.next != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}
