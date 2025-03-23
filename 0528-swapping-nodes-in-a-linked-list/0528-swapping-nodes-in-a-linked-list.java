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
        ListNode kstart = null;
        ListNode kend = null;
        int size = 0;
        ListNode curr = head;

        while(curr != null){
            size++;
            curr = curr.next;
        }

        int temp = k;
        int tem = 0;
        curr = head;

        while(curr != null){
            if(temp-- > 0){
                kstart = curr;
            }
            if(tem <= size - k){
                kend = curr;
                tem++;
            }
            curr = curr.next;
        }

        temp = kstart.val ;
        kstart.val = kend.val;
        kend.val = temp; 

        return head;
    }
}