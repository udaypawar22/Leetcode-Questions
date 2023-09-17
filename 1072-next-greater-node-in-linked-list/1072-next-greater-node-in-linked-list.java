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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int arr[];

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        arr = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                arr[stack.peek()] = list.get(i);
                stack.pop();
            }
            stack.add(i);
        }

        return arr;
    }
}