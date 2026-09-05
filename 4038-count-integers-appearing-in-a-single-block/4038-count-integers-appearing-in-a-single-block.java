class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] cnt = new int[101];
        int res = 0; 
        int a = nums.length;
        
        for(int i = 0; i<a; i++){
            if(i == 0 || nums[i] != nums[ i-1]){
                cnt[nums[i]]++;
            }}
        for(int n : cnt){
            if(n == 1){
                res++;
            }
        }
        return res;
    }
}