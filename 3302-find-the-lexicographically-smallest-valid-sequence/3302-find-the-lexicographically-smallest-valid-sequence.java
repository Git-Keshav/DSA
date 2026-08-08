class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n+1];
        int j = m -1;

        for(int i = n-1; i >= 0; i--){
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)){
                j--;
            }
            suf[i] = m - 1 -j;
        }

        int[] ans = new int[m];
        int ansInd = 0;

        j =0;
        boolean cng = false;

        for(int i = 0; i< n && j < m; i++){
            if(word1.charAt(i) == word2.charAt(j)){
                ans[ansInd++] = i;
                j++;
            }
            else if(!cng && suf[i +1] >= m-1 -j){
                ans[ansInd++] = i;
                j++;
                cng = true;
            }
        }

        if(j == m){
            return ans;
        }

        return new int[0];
    }
}