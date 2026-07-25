class Solution {
    public int maxProduct(int n) {
        int max_1 = 0;
        int max_2 = 0;
        
        while(n > 0){
            int l = n % 10;
            
            if(l > max_1){
                max_2 = max_1;
                max_1 = l;
            }else if(l > max_2){
                max_2 = l;
            }
            n /= 10;
        }
        return max_1 *max_2;
    }
}