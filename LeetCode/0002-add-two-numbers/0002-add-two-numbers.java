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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode last = null;
        int remainingCost = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                remainingCost += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                remainingCost += l2.val;
                l2 = l2.next;
            }

            int nowCost = remainingCost % 10;
            remainingCost /= 10;
            
            if(result == null) {
                last = result = new ListNode(nowCost);
            } else {
                ListNode next = new ListNode(nowCost);
                last.next = next;
                last = next;
            }
        }

        if(remainingCost > 0) {
            ListNode next = new ListNode(remainingCost);
            last.next = next;
        }

        return result;
    }
}