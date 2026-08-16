class Solution {
    public boolean stoneGameIX(int[] stones) {
        int C1 =0;
        int C2 = 0;
        int C3 = 0;

        for(int e : stones){
            if(e % 3 == 0){
                C1++;
            }else if(e % 3 == 2){
                C2++;
            }else{
                C3++;
            }
        }
        if(C1 % 2 == 0){
            return C2 >= 1 && C3 >= 1;
        }
        return Math.abs(C2 - C3) > 2;

    }
}