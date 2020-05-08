/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0);
        ListNode res = prev;
        prev.next = head;
        while (prev.next != null && prev.next.next != null) {
            ListNode n1 = prev.next;
            ListNode n2 = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            prev.next = n2;
            prev = n1;
        }
        return res.next;
    }
}