/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode f = head.next;
        ListNode s = head;
        while(s != f) {
            if(f.next == null || f.next.next == null) return null;
            f = f.next.next;
            s = s.next;
        }
        ListNode c = head;
        while(s.next != c) {
            c = c.next;
            s = s.next;
        }
        return c;
    }
}