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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode[] ptrArr = new ListNode[k];
        ListNode ans = null;
        ListNode head = null;
        for(int i = 0; i < k; i++) {
            ptrArr[i] = lists[i];
        }
        while(true) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for(int i = 0; i < k; i++) {
                if (ptrArr[i] != null && min > ptrArr[i].val) {
                    min = ptrArr[i].val;
                    min_index = i;
                }
            }
            if (min_index == -1) break;
            if (ans == null) {
                head = ptrArr[min_index];
                ans = head;
            } else {
                ans.next = ptrArr[min_index];
                ans = ptrArr[min_index];
            }
            ptrArr[min_index] = ptrArr[min_index].next;
        }
        return head;
    }
}