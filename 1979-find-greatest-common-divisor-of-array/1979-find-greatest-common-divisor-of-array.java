class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for( int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }else if (nums[i] > max) {
                max = nums[i];
            }
        }
        return gcd(min, max);
         
    }
    private int gcd(int n1, int n2){
        while(n2 != 0){
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}