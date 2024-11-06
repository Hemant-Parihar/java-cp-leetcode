/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        int len = 0;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }
        int x = len - n;

        if (x == 0) return head.next;

        ptr = head;
        x--;
        while(x > 0) {
            ptr = ptr.next;
            x--;
        }
        if (n != 1) {
            ptr.next = ptr.next.next;
        } else {
            ptr.next = null;
        }
        return head;
    }
}