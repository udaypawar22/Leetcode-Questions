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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int grid[][] = new int[m][n];
        char dir = 'r';
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        int i = 0, j = 0, k = 0;
        while (head != null) {
        grid[i][j] = head.val;
        if (dir == 'r') {
            if (j < n - 1 && grid[i][j + 1] == -1) {
                j++;
            } else {
                dir = 'd';
                i++;
            }
        } else if (dir == 'd') {
            if (i < m - 1 && grid[i + 1][j] == -1) {
                i++;
            } else {
                dir = 'l';
                j--;
            }
        } else if (dir == 'l') {
            if (j > k && grid[i][j - 1] == -1) {
                j--;
            } else {
                dir = 'u';
                i--;
                k++;
            }
        } else if (dir == 'u') {
            if (i > k && grid[i - 1][j] == -1) {
                i--;
            } else {
                dir = 'r';
                j++;
            }
        }
        head = head.next;
    }
    return grid;
    }
}