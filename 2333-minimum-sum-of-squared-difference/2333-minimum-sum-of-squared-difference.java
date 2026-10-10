class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        
        int[] diffCounts = new int[100001];
        long totalDiff = 0;
        int maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                diffCounts[diff]++;
                maxDiff = Math.max(maxDiff, diff);
                totalDiff += diff;
            }
        }
        
        if (totalDiff <= k) {
            return 0;
        }
        
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (diffCounts[d] > 0) {
                long reductions = Math.min(k, (long) diffCounts[d]);
                
                diffCounts[d] -= reductions;
                diffCounts[d - 1] += reductions;
                k -= reductions;
            }
        }
        
        long minSumSquared = 0;
        for (long d = 1; d <= maxDiff; d++) {
            if (diffCounts[(int) d] > 0) {
                minSumSquared += diffCounts[(int) d] * (d * d);
            }
        }
        
        return minSumSquared;
    }
}