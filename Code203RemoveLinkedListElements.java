/**
 * @Author: ybchen
 * @Date: 2021/2/23 16:36
 */
public class Code203RemoveLinkedListElements {

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


    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode curNode = head;
        ListNode nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            if (curNode.val == val) {
                preNode.next = nextNode;
                if (curNode.val != val) {
                    preNode = curNode;
                }
            } else {
                preNode = curNode;
            }
            curNode = nextNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //1->2->6->3->4->5->6
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode newHead = removeElements(head, 6);
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

    }
}
