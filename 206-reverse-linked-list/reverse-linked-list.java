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
    public ListNode reverseList(ListNode head) {
        return solve(head, null);
    }

    ListNode solve(ListNode head, ListNode newHead) {
        if (head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return solve( next, head);
    }
}