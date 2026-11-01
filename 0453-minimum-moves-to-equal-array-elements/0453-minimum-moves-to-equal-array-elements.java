class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        
        for(int i : nums){
            sum += i;
            min = Math.min(min, i);
            
        }

        return sum - nums.length * min;
    }
}