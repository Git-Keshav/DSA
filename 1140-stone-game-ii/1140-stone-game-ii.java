class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] sSum = new int[n];
        sSum[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i--){
            sSum[i] = sSum[i+1] + piles[i];
        }
        Integer[][] s = new Integer[n][n-1];

        return fun(0,1,piles, sSum, s ,n);
    }

    private int fun(int index, int M, int[] piles, int[] sSum, Integer[][] s, int n){
        if(index >= n){
            return 0;
        }
        if(index + 2 * M >= n){
            return sSum[index];
        }
        if(s[index][M] != null){
            return s[index][M];
        }
        int maxStn = 0;

        for(int X = 1; X<= 2*M; X++){
            int opSc = fun(index + X, Math.max(M,X), piles, sSum, s, n);

            int mSc = sSum[index] - opSc;

            maxStn = Math.max(maxStn, mSc);
        }
        s[index][M] = maxStn;
        return maxStn;
    }
}