/**
 * @Author: ybchen
 * @Date: 2021/2/20 9:57
 */
public class Code92ReverseLinkedListII {

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode endNode = null;
        ListNode startNode = head;
        left = left - 2;
        right = right - 1;
        while (0 <= right) {
            if (left-- == 0) {
                preNode = curNode;
            }
            if (right-- == 0) {
                endNode = curNode;
            }
            curNode = curNode.next;

        }
        if (preNode != null) {
            startNode = preNode.next;
        }
        ListNode nextNode = endNode.next;
        endNode.next = null;
        if (preNode != null) {
            preNode.next = null;
        }
        reverseBetween(startNode, endNode);
        if (preNode != null) {
            preNode.next = endNode;
        }
        startNode.next = nextNode;
        return preNode == null ? endNode : head;

    }


    public static void reverseBetween(ListNode startNode, ListNode endNode) {
        if (startNode == endNode) {
            return;
        }
        ListNode pre = null;
        ListNode cur = startNode;
        ListNode next;
        ListNode endNext = endNode.next;
        while (cur != endNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return;//which means newHead
    }

    public static void main(String[] args) {
        //
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newHead = reverseBetween(head, 1, 4);
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

    }
}
