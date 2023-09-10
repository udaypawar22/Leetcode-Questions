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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode arr[] = new ListNode[k];
        ListNode temp = head;
        ListNode prev = null;
        int n = 0;

        if(head == null) {
            return arr;
        }
        if(head.next == null) {
            arr[0] = head;
            return arr;
        }

        while(temp != null) {
            n++;
            temp = temp.next;
        }
        
        int i = 0, j = 0, size = 0;
        boolean flag = true;
        temp = head;

        while(temp != null) {
            if(flag) {
                if(i < (n % k)) {
                    size = (n / k) + 1;
                } else {
                    size = n / k;
                }
                flag = false;
            }
            
            if (j < size) {
                if(arr[i] == null) {
                    prev = temp;
                    arr[i] = prev;
                    temp = temp.next;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
                j++;
            } else {
                prev.next = null;
                flag = true;
                j = 0;
                i++;
            }
        }
        prev.next = null;
        return arr;
    }
}