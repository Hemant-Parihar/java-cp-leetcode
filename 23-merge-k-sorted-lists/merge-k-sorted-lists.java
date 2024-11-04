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
        if (k == 0) return null;
        if (k == 1) return lists[0];
        int jump = 1;
        while(jump < k) {
            for(int i = 0; (i + jump) < k; i = i + 2*jump) {
                System.out.println("i: " + i + " i + jump : " + (i + jump));
                lists[i] = merge(lists[i], lists[i + jump]);
            }
            jump = 2 * jump;
        }
        return lists[0];
    }

    void print(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    ListNode merge(ListNode node1, ListNode node2) {
        
        // print(node1);
        // print(node2);

        ListNode ptr1 = node1;
        ListNode ptr2 = node2;
        ListNode root = null;
        ListNode ans = null;

        while(ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                if (root == null) {
                    root = ptr1;
                    ans = root;
                } else {
                    ans.next = ptr1;
                    ans = ans.next;
                }
                ptr1 = ptr1.next;
            } else {
                if (root == null) {
                    root = ptr2;
                    ans = root;  
                } else {
                    ans.next = ptr2;
                    ans = ans.next;
                }
                ptr2 = ptr2.next;
            }
        }

        if (ptr1 == null) {
            if (root == null) return ptr2;
            ans.next = ptr2;
        }

        if (ptr2 == null) {
            if (root == null) return ptr1;
            ans.next = ptr1;
        }

        // print(root);

        return root;
    }
}