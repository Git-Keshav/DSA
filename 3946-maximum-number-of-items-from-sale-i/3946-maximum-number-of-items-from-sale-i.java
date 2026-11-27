class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int minPrice = Integer.MAX_VALUE;
        int maxFactor = 0;

        for(int[] i : items){
            maxFactor = Math.max(maxFactor, i[0]);
            minPrice = Math.min(minPrice, i[1]);
        }

        int[] freq = new int[maxFactor + 1];
        for(int[] i: items){
            freq[i[0]]++;
        }
        int[] multi = new int[maxFactor +1];
        for(int d = 1; d <= maxFactor; d++){
            for(int f = d; f <= maxFactor; f+=d){
                multi[d] += freq[f];
            }
        }

        int[] dp = new int[budget +1];
        for(int[] j: items){
            int val = multi[j[0]];
            int p = j[1];
            for(int b = budget; b >= p; b--){
                dp[b] = Math.max(dp[b], dp[b -p] + val);
            }
        }
        int ans = 0;
        for(int b = 0; b <= budget; b++){
            ans = Math.max(ans, dp[b] + (budget - b) / minPrice);
        }
        return ans;
    }
}