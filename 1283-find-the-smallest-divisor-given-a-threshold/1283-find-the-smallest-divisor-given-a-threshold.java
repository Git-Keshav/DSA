class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long start = 1; long end = 0;

        for(int i : nums){
            end += i;
        }

        while(start <= end){
            long mid = start + (end -start) /2;

            if(isValid(nums, threshold, mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int)start;
    }
    private boolean isValid(int[] nums, int threshold, long mid){
        long sum = 0; 
        for(int i : nums){
            if(i % mid == 0){
                sum += i/mid;
            }else{
                sum += i/mid + 1;
            }
        }
        return sum > threshold;
    }
}