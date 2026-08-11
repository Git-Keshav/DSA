class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for(int i = 1; i < nums.length && nums[i] == nums[i -1] +1; i++){
            sum += nums[i];
        }
        boolean f = true;
        while(f){
            f = false;
            for(int n : nums){
                if(n == sum){
                    sum++;
                    f = true;
                    break;
                }
            }
        }
        return sum;
    }
}