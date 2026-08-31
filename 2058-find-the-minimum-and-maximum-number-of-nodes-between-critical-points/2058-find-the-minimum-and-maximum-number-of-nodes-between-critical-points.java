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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstC = -1;
        int prevC = -1;

        int minDis = Integer.MAX_VALUE;

        int ind = 1;

        ListNode prev = head;
        ListNode cur = head.next;

        while(cur.next != null){
            ListNode next = cur.next;

            boolean isMax = cur.val > prev.val && cur.val > next.val;

            boolean isMin = cur.val < prev.val && cur.val < next.val;

            if(isMax || isMin){
                if(firstC == -1){
                    firstC = ind;
                }else{
                    int dis = ind - prevC;
                    minDis = Math.min(minDis, dis);
                }
                prevC = ind;
            }
            prev = cur;
            cur = next;
            ind++;
        }
        if(firstC == prevC){
                return new int[]{-1, -1};
        }

        int maxDist = prevC - firstC;

        return new int[]{minDis, maxDist};
    }
}