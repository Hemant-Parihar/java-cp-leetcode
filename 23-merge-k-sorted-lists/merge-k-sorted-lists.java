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

        ListNode root = null;
        ListNode ptr = null;
        while(true) {
            int min_index = -1;
            int min_val = Integer.MAX_VALUE;
            for(int i = 0; i < k; i++) {
                if (lists[i] != null && min_val > lists[i].val) {
                    min_val = lists[i].val;
                    min_index = i;
                }
            }

            if (min_index == -1) break;

            if (root == null) {
                root = lists[min_index];
                ptr = root;
            } else {
                ptr.next = lists[min_index];
                ptr = ptr.next;
            }

            lists[min_index] = lists[min_index].next;
        }

        return root;
    }
}