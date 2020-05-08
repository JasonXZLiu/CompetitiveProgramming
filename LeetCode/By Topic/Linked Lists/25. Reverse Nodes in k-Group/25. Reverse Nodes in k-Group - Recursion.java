/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode newHead = head;
        for (int i = 0; i < k - 1; i++) {
            newHead = newHead.next;
            if (newHead == null) return head;
        }
        newHead.next = reverseKGroup(newHead.next, k);
        ListNode prev = head, cur = prev.next;
        for(int i = 0; i < k - 1; i++) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
        }
        head.next = cur;
        return newHead;
    }
}