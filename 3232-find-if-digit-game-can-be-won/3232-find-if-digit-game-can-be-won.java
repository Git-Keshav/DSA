class Solution {
    public boolean canAliceWin(int[] nums) {
        int AliceSum = 0;
        int Bobsum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10) {
                AliceSum += nums[i];
            } else {
                Bobsum += nums[i];
            }
        }

        return AliceSum != Bobsum;
    }
}