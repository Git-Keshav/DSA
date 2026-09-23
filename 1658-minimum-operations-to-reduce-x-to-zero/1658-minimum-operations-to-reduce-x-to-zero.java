class Solution {
    public int minOperations(int[] nums, int x) {
        int sumAll = 0;
        for (int element : nums) {
            sumAll += element;
        }
        
        int requiredSum = sumAll - x;
        
        if (requiredSum == 0) {
            return nums.length;
        }
        
        if (requiredSum < 0) {
            return -1;
        }
        
        int longestSubarray = -1;
        int windowSum = 0;
        int start = 0;
        
        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            
            while (windowSum > requiredSum && start <= end) {
                windowSum -= nums[start];
                start++;
            }
            
            if (windowSum == requiredSum) {
                longestSubarray = Math.max(longestSubarray, end - start + 1);
            }
        }
        
        return longestSubarray != -1 ? nums.length - longestSubarray : -1;
    }
}