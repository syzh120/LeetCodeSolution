/**
 * @Author: ybchen
 * @Date: 2021/2/23 10:30
 */
public class Code234PalindromeLinkedList {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode newHead = reverseBetween(middleNode);
        boolean result = isPalindrome(head, newHead);
        reverseBetween(newHead);
        return result;
    }

    public static boolean isPalindrome(ListNode head1, ListNode head2) {
        while (head1 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }


    public static ListNode getMiddleNode(ListNode head) {
        ListNode slower = head;
        ListNode fastNode = slower.next;
        while (fastNode != null && fastNode.next != null) {
            slower = slower.next;
            fastNode = fastNode.next.next;
        }
        return slower;
    }


    public static ListNode reverseBetween(ListNode startNode) {

        ListNode preNode = null;
        ListNode cur = startNode;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }
        return preNode;//which means newHead
    }

    public static void main(String[] args) {
        //
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        boolean result = isPalindrome(head);
        System.out.println(result);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }

    }
}
