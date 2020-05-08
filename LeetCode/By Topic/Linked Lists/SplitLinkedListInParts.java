/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 1) return new ListNode[]{root};
        
        int size = 0;
        ListNode tmp = root;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        ListNode[] res = new ListNode[k];
        int q = size / k;
        int r = size % k;
        int idx = 0;
        while (root != null) {
            ListNode temp = root;
            for (int i = 0; i < q - 1; i++) {
                root = root.next;
            }
            if (r > 0 && size > k) {
                ListNode next = root.next.next;
                root.next.next = null;
                r--;
                res[idx++] = temp;
                root = next;
            } else {
                ListNode next = root.next;
                root.next = null;
                res[idx++] = temp;
                root = next;
            }
        }
        return res;
    }
}