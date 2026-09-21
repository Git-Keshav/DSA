class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        
        long[] dp = new long[k];

        for (int num : nums) {
            int val = num % k;
            long[] nextDp = new long[k];

            nextDp[val]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nextRem = (int) ((1L * r * val) % k);
                    nextDp[nextRem] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                res[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return res;
    }
}