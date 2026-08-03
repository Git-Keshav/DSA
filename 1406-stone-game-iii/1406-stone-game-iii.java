class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int maxDiff = Integer.MIN_VALUE;
            int take = 0;
            
            
            take += stoneValue[i];
            maxDiff = Math.max(maxDiff, take - dp1);
            
            if (i + 1 < n) {
                take += stoneValue[i + 1];
                maxDiff = Math.max(maxDiff, take - dp2);
            }
            
            if (i + 2 < n) {
                take += stoneValue[i + 2];
                maxDiff = Math.max(maxDiff, take - dp3);
            }
            
            dp3 = dp2;
            dp2 = dp1;
            dp1 = maxDiff;
        }
        
        if (dp1 > 0) {
            return "Alice";
        } else if (dp1 < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}