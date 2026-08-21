class Solution {
    private long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    private long lcm(long a, long b) { return a / gcd(a, b) * b; }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int sz = 1 << n; 
        
        long[] L = new long[sz];
        int[] S = new int[sz];
        long min = coins[0];
        
        for (int x : coins) min = Math.min(min, x);
        
        for (int i = 1; i < sz; i++) {
            long cur = 1;
            int b = 0;
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    b++;
                    cur = lcm(cur, coins[j]);
                }
            }
            L[i] = cur;
            S[i] = (b % 2 == 1) ? 1 : -1;
        }
        
        long l = 1;
        long h = min * k;
        long ans = h;
        
        while (l <= h) {
            long m = l + (h - l) / 2;
            long cnt = 0;
            
            for (int i = 1; i < sz; i++) {
                cnt += (m / L[i]) * S[i];
            }
            
            if (cnt >= k) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return ans;
    }
}