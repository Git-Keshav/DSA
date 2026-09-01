class Solution {
    public void moveZeroes(int[] nums) {
        int l = nums.length;

        for(int i = 0; i < l; i++){
            if(nums[i] == 0){
                int j = i +1;
                while(j < l && nums[j] == 0){
                    j++;
                }
                if(j < l){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }
}