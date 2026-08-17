class Solution {
    int[][] df;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        df = new int[n][n];
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        return dfs(stoneValue, 0, n - 1, prefixSum);
    }
    
    private int dfs(int[] stoneValue, int l, int r, int[] prefixSum) {
        if (l == r) {
            return 0;
        }
        if (df[l][r] != 0){
            return df[l][r];
        }

        int ans = 0;
        for (int i = l; i < r; i++) {
            int lSum = prefixSum[i + 1] - prefixSum[l];
            int rSum = prefixSum[r + 1] - prefixSum[i + 1];

            if (lSum < rSum){
                ans = Math.max(ans, lSum + dfs(stoneValue, l, i, prefixSum));
            }else if (lSum > rSum){
                ans = Math.max(ans, rSum + dfs(stoneValue, i + 1, r, prefixSum));
            }
            else{
                ans = Math.max(ans, lSum + Math.max(dfs(stoneValue, l, i, prefixSum), dfs(stoneValue, i + 1, r, prefixSum)));
            }
        }
        return df[l][r] = ans;
    }
}