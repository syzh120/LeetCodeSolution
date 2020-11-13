import sun.rmi.log.LogInputStream;

/**
 * @Author: ybchen
 * @Date: 2020/11/13 11:27
 */
public class Code25ReverseKGroup {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     *  
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     *  
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int K = k;
        if (head == null || k == 1) {
            return head;
        }
        ListNode end = head;
        while (end != null && k > 1) {
            end = end.next;
            k = k - 1;
        }
        //which means not enough nodes
        if (end == null) {
            return head;
        }
        ListNode endNext = end.next;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        ListNode node = reverseKGroup(endNext, K);
        head.next = node;
        return end;
    }

    public static ListNode reverseKGroupVer1(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int K = k;
        ListNode end = head;
        ListNode preNode = dummy;
        ListNode resNode = head;
        ListNode cur = head;
        while (end != null) {
            while (k > 1 && end != null) {
                k--;
                end = end.next;
            }
            k = K;
            if (end == null) {
                break;
            }
            ListNode endNext = end.next;
            ListNode pre = null;
            ListNode next;
            ListNode temp = cur;
            if (resNode == head) {
                resNode = end;
            }

            while (cur != end) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            cur.next = pre;
            preNode.next=end;
            preNode = temp;
            cur = endNext;
            end=cur;
            temp.next = endNext;
        }
        return resNode;

    }
//    public boolean canReverse(ListNode head, int k) {
//        ListNode cur = head;
//        while (k > 1 && cur != null) {
//            k--;
//            cur = cur.next;
//        }
//        return k == 1;
//    }

    public ListNode reverseKNodes(ListNode head,int k){
        ListNode end=head;
        while (k > 1 && end != null) {
            k--;
            end = end.next;
        }
        //which means not enough nodes
        if(end==null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return end;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
       // ListNode node5=new ListNode(6);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
       // node4.next=node5;
        ListNode newHead=reverseKGroupVer1(head,3);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

    }


}
