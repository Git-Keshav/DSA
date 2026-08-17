class Solution {
    int[][] memo;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        return dfs(stoneValue, 0, n - 1, prefixSum);
    }
    
    private int dfs(int[] stoneValue, int left, int right, int[] prefixSum) {
        if (left == right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int ans = 0;
        for (int i = left; i < right; i++) {
            int leftSum = prefixSum[i + 1] - prefixSum[left];
            int rightSum = prefixSum[right + 1] - prefixSum[i + 1];
            if (leftSum < rightSum) ans = Math.max(ans, leftSum + dfs(stoneValue, left, i, prefixSum));
            else if (leftSum > rightSum) ans = Math.max(ans, rightSum + dfs(stoneValue, i + 1, right, prefixSum));
            else ans = Math.max(ans, leftSum + Math.max(dfs(stoneValue, left, i, prefixSum), dfs(stoneValue, i + 1, right, prefixSum)));
        }
        return memo[left][right] = ans;
    }
}