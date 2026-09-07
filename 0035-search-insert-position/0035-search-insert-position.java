class Solution {
    public int searchInsert(int[] nums, int target) {
        int f = 0;
        int e = nums.length -1;

        while ( f <= e){
            int m = f +(e - f)/ 2;
            if(nums[m] == target){
                return m;

            }else if(nums[m] > target){
                e = m -1;
            }else{
                f = m + 1;
            }
        }
        
        return f;
    }
}