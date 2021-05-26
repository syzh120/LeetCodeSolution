/**
 * @Author: ybchen
 * @Date: 2021/5/25 13:47
 */
public class Code86PartitionList {
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

    /**
     * 模拟快排的切分算法
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }


        return head;
    }


    public static void main(String[] args) {
        //1,4,3,2,5,2
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newHead = partition(head, 3);
        ListNode curNode = newHead;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }

    }
}
