class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        boolean isSorted = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            return 0;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                if (ans == -1) {
                    ans = nums[i];
                } else {
                    ans &= nums[i];
                }
            }
        }
        
        return ans;
    }
}