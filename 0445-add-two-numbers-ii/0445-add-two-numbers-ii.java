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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        boolean carry = false;
        ListNode prev = null;
        int num = 0;
        
        // if(l1 == null && l2 == null) {
        //     return ;
        // }
        
        
        while(l1 != null && l2 != null) {
            s1.push(l1.val);
            s2.push(l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int a = s1.pop();
            int b = s2.pop();
            int sum = a + b;
            
            if(carry) {
                sum += 1;
            }
            
            if(sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            
            num = sum % 10;
            
            ListNode ne = new ListNode(num, null);
            if(prev == null) {
                ne.next = null;
                prev = ne;
            } else {
                ne.next = prev;
                prev = ne;
            }
        }
        
        while(!s1.isEmpty()) {
            int sum = s1.pop();
            
            if(carry) {
                sum += 1;
            }
            if(sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            
            num = sum % 10;
            
            ListNode ne = new ListNode(num, null);
            if(prev == null) {
                ne.next = null;
                prev = ne;
            } else {
                ne.next = prev;
                prev = ne;
            }
        }
        while(!s2.isEmpty()) {
            int sum = s2.pop();
            
            if(carry) {
                sum += 1;
            }
            if(sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            
            num = sum % 10;
            
            ListNode ne = new ListNode(num, null);
            if(prev == null) {
                ne.next = null;
                prev = ne;
            } else {
                ne.next = prev;
                prev = ne;
            }
        }
        if(carry) {
            ListNode ne = new ListNode(1, prev);
            prev = ne;
        }
        return prev;
    }
}