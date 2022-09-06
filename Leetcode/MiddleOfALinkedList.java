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
    public ListNode middleNode(ListNode head) {
       ListNode counter = head;
        ListNode middle = head;
        
        int count = 0;
        
        while(counter!=null){
            counter = counter.next;
            count++;
        }
        
        if(count>1){
            count/=2;
            int chk = 0;
            while(chk!=count){
                middle = middle.next;
                chk++;
            }
        }
        
        return  middle;
    }
}