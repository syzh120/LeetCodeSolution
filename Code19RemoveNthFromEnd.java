/**
 * @Author: ybchen
 * @Date: 2020/11/11 16:27
 */
public class Code19RemoveNthFromEnd {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;
        ListNode faster = head;
        ListNode slower = head;
        ListNode pre = null;
        while (n > 1) {
            faster = faster.next;
            n--;
        }
        while (faster.next != null) {
            faster = faster.next;
            pre = slower;
            slower = slower.next;
        }
        if (pre == null) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        pre.next = slower.next;
        slower.next = null;
        return head;
    }

}
