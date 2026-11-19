class Solution {
    public int minimizeSum(int[] nums) {
        int n0 = Integer.MAX_VALUE, n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        int l0 = 0;
        int l1 = 0;
        int l2 = 0;

        for(int x: nums){
            if(x < n0){
                n2 = n1;
                n1 = n0;
                n0 = x;
            }else if(x < n1){
                n2 = n1;
                n1 = x;
            }else if(x < n2){
                n2 = x;
            }
            if(x > l0){
                l2 = l1;
                l1 = l0;
                l0 = x;
            }else if(x > l1){
                l2 = l1;
                l1 = x;
            }else if(x > l2){
                l2 = x;
            }
        }
        return Math.min(l0 - n2, Math.min(l2 - n0, l1 - n1));
    }
}