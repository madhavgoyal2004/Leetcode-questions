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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = new ListNode(0);
        ListNode dummy = l3;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        while(l1 != null){
            l3.next = new ListNode(l1.val);
            l3 = l3.next;
            l1 = l1.next;
        }
        while(l2 != null){
            l3.next = new ListNode(l2.val);
            l3 = l3.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}