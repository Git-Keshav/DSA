class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        int l = nums.length;

        for(int n : nums){
            if(n != 0){
                nums[cnt++] = n;
            }    
        }
        while(cnt < l){
                nums[cnt++] = 0;
            }
    }
}