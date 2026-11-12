class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 0;

        for(int n = 0; n < nums.length; n++){
            int currLength = 1;

            for(int m = n+1; m < nums.length; m++){
                if(nums[m] > nums[m -1]){
                    currLength += 1;
                }else{
                    break;
                }
            }
            maxLength = Math.max(maxLength, currLength);
        }

        for(int i = 0; i < nums.length; i++){
            int currLength = 1;

            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[j -1]){
                    currLength += 1;
                }else{
                    break;
                }
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}