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
    public ListNode reverse(ListNode head, ListNode last){
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        while(curr != last){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int size = 0;
        ListNode point = head;
        while(point != null){
            size++;
            point = point.next;
        }
        // System.out.println(size);
        
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = head;
        boolean isfirst = false;
        int count = 0;
        int i = size / k;
        // System.out.println(i);

        while(i-- > 0){
            int n = k;
            while(next != null && n-- > 0){
                next = next.next;
            }
            // System.out.println(prev.val + " " + curr.val + " " + next.val);
            ListNode new_curr = reverse(curr, next);
            if(!isfirst){
                head = new_curr;
                isfirst = true;
                curr = next;
                continue;
            }
            // System.out.println(head.val);
            prev.next = new_curr;
            prev = curr;
            curr = next;
        }
        prev.next = next;
        return head;
    }
}