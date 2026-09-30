class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = 0, sum = 0;
        double maxAvg = Double.NEGATIVE_INFINITY; 
        
        for(; end < nums.length; end++){
            sum += nums[end];
            if((end - start + 1) == k){
                maxAvg = Math.max(maxAvg, ((double)sum / k));
                sum -= nums[start];
                start += 1;
            }
        }
        return maxAvg;
    }
}