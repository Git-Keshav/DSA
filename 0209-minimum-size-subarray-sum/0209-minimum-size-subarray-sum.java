class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int WinSum = 0;
        int minLeng = Integer.MAX_VALUE;

        for(int end = 0; end < nums.length; end++){
            WinSum += nums[end];
            while(WinSum >= target){
                minLeng = Math.min(minLeng, end-start + 1);
                WinSum -= nums[start];
                start++;
            }
        }
        return minLeng == Integer.MAX_VALUE ? 0 : minLeng;
    }
}