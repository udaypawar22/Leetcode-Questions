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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int n = 1;
        int i = 0;
        int index = 0;

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        while(temp.next != null) {
            temp = temp.next;
            n++;
        }

        k %= n;

        if(k == 0) {
            return head;
        }
        
        temp.next = head;

        index = n - k;

        while(i < index) {
            head = head.next;
            i++;
        }

        System.out.println("n " + n);
        System.out.println("head " + head.val);
        System.out.println("i " + i);

        temp = head.next;

        while(temp.next != head) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }
}