class Solution {
    public int singleNonDuplicate(int[] nums) {
        int a = 0;
        int b = nums.length -1;

        while (a < b){
            int m = a + (b - a) / 2;

            if(m % 2 == 1){
                m--;
            }
            if (nums[m] != nums[m + 1]){
                b = m;
            }else{
                a = m + 2;
            }
        }
        return nums[a];

    }
}