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
    public ListNode swapNodes(ListNode head, int k) {
        // ListNode prevstart = null;
        ListNode kstart = null;
        // ListNode nextstart = null;
        // ListNode prevend = null;
        ListNode kend = null;
        // ListNode nextend = null;
        int size = 0;
        ListNode c = head;

        while(c != null){
            size++;
            c = c.next;
        }
        System.out.println(size);

        int temp = k;
        int tem = 0;
        ListNode curr = head;

        while(curr != null){
            if(temp-- > 0){
                // prevstart = curr;
                kstart = curr;
            }
            if(tem <= size - k){
                // prevend = curr;
                kend = curr;
                tem++;
            }
            curr = curr.next;
        }

        // System.out.println(prevstart.val + " " + prevend.val);
        // kstart = prevstart.next;
        // System.out.println(kstart.val);
        // if(prevend.next != null) kend = prevend.next;
        // if(kend.next != null) nextend = kend.next;
        
        // if(kstart.next != null)nextstart = kstart.next;

        int t = kstart.val ;
        kstart.val = kend.val;
        kend.val = t; 

        return head;
    }
}