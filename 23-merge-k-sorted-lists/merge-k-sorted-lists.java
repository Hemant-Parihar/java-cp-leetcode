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
        int intervals = 1;
        while(intervals < k) {
            for(int i = 0; i + intervals < k; i += 2 * intervals) {
                // System.out.println("call " + i + " " + (i + intervals));
                lists[i] = merge(lists[i], lists[i + intervals]);
            }
            intervals = intervals << 1;
        }
        return k == 0 ? null : lists[0];
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode ptr = null;
        while(l1 != null && l2 != null) {
            // System.out.println(l1.val + " " + l2.val);
            if (head == null) {
                if (l1.val <= l2.val) {
                    head = l1;
                    l1 = l1.next;
                    ptr = head;
                } else {
                    head = l2;
                    l2 = l2.next;
                    ptr = head;
                }
            } else {
                if (l1.val <= l2.val) {
                    ptr.next = l1;
                    ptr = l1;
                    l1 = l1.next;
                } else {
                    ptr.next = l2;
                    ptr = l2;
                    l2 = l2.next;
                }
            }
        }

        if (l1 != null) {
            if (ptr == null) {
                head = l1;
            } else {
                ptr.next = l1;
            }
        }

        if (l2 != null) {
            if (ptr == null) {
                head = l2;
            } else {
                ptr.next = l2;
            }
        }

        return head;
    }


}