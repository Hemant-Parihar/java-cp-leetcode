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
    ListNode head = null;
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode[] ptrArr = new ListNode[k];
        ListNode ans = null;
        for(int i = 0; i < k; i++) {
            ptrArr[i] = lists[i];
        }
        solve(ptrArr, lists, ans);
        return head;
    }

    void solve(ListNode[] ptrArr, ListNode[] lists, ListNode ans) {
        int k = lists.length;

        while(true) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for(int i = 0; i < k; i++) {
                if (ptrArr[i] != null && min > ptrArr[i].val) {
                    min = ptrArr[i].val;
                    min_index = i;
                }
            }
            if (min_index == -1) return;
            if (ans == null) {
                head = ptrArr[min_index];
                ans = head;
                ptrArr[min_index] = ptrArr[min_index].next;
            } else {
                ans.next = ptrArr[min_index];
                ans = ptrArr[min_index];
                ptrArr[min_index] = ptrArr[min_index].next;
            }
        }
    }
}