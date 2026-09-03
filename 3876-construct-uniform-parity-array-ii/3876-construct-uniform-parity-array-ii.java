class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        boolean allEv = true;
        for(int x : nums1){
            min = Math.min(min, x);

            if(x% 2 != 0){
                allEv = false;
            }
        }

        if(min % 2 != 0){
            return true;
        }
        if(allEv){
            return true;
        }
        return false;
    }
}