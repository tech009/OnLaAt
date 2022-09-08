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
    
    public String add(String num1, String num2){
        
        int carry = 0;
        int sum = 0;
        int a = 0;
        int b = 0;
        
        int size1 = num1.length();
        int size2 = num2.length();
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        int size = (size1>size2)?size1:size2;
        
        while(count!=size){
            sum = 0;
            a = 0;
            b = 0;
            
            if(count<size1)
                a = (int)(num1.charAt(count) - '0');
            if(count<size2)
                b = (int)(num2.charAt(count) - '0');
            
            sum = a+b+carry;
            carry = sum/10;
            sb.append(sum%10);
            count++;
        }
        if(carry>0)
            sb.append(carry);
        return sb.toString();
    }
    
    public ListNode listMaker(String num){
        
        StringBuilder sb = new StringBuilder(num);
        num = sb.reverse().toString();
        
        ListNode l = null;
        for(char c: num.toCharArray())
            l = new ListNode((int)(c-'0'), l);
        
        return l;
    }
    
    public String numberMaker(ListNode list){
        
        StringBuilder sb = new StringBuilder();
        while(list!=null){
            sb.append(list.val);
            list = list.next;
        }
        
        return sb.toString();
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        String num1 = numberMaker(l1);
        String num2 = numberMaker(l2);
        
        String num = add(num1, num2);
        
        ListNode l = listMaker(num);
        if(l==null)
            return new ListNode(0);
        return l;
    }
}