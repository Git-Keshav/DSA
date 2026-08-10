class Solution {
    
    public boolean winnerSquareGame(int n) {
        boolean dp[] = new boolean[n + 1];
        
        for(int a = 0; a <= n; a++){
            if(!dp[a]){
                for(int b = 1; a + b * b <= n; b++ ){
                    dp[a + b * b] = true;
                }
                if(dp[n]){
                    return true;
                }
            }
        }
        return  false;
    }
}