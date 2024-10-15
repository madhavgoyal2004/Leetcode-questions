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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode currnode = head;
        ListNode prevnode = head;

        while (currnode != null){
            if(currnode.val != prevnode.val){
                prevnode.next = currnode;
                prevnode = prevnode.next;
            }
            currnode = currnode.next;
        }

        prevnode.next = null;

        return head;
    }
}