class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] mScDiff = new int[n];

        for(int i = 0; i < n; i++){
            mScDiff[i] = piles[i];
        }

        for(int len = 2; len <= n; len++){
            for(int i=0; i <= n - len; i++){
                int j = i + len -1;

                mScDiff[i] = Math.max(piles[i] - mScDiff[ i + 1], piles[j] - mScDiff[i]);
            }
        }
        return mScDiff[0] > 0;
    }
}