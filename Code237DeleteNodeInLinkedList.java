/**
 * @Author: ybchen
 * @Date: 2021/2/23 16:20
 */
public class Code237DeleteNodeInLinkedList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void deleteNode(ListNode node) {
        ListNode preNode = node;
        ListNode curNode = node.next;
        while (curNode != null) {
            node.val = curNode.val;
            preNode = node;
            node = curNode;
            curNode = curNode.next;
        }
        preNode.next = null;

    }

    public static void main(String[] args) {
        //
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node2);
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

    }
}
