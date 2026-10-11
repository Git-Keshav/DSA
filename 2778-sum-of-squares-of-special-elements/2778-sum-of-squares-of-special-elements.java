class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i< n; i++){
            if(isValid(n, i + 1)){
                sum += nums[i] * nums[i];
            }
        }
        return sum;
    }
    private boolean isValid(int n, int a){
        if(n % a == 0){
            return true;
        }
        return false;
    }
}