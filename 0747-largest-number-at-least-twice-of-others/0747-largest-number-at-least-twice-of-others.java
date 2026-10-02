class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int maxIndex = -1;
        int secMax = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secMax) {
                secMax = nums[i];
            }
        }
        
        if (max >= 2 * secMax) {
            return maxIndex;
        }
        
        return -1;
    }
}