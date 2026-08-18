class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] cnt = new int[51];
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];
            for (int j = i; j < i + k; j++) {
                int val = nums[j];
                if (!seen[val]) {
                    seen[val] = true;
                    cnt[val]++;
                }
            }
        }

        for (int val = 50; val >= 0; val--) {
            if (cnt[val] == 1) {
                return val;
            }
        }
        return -1;        
    }

}