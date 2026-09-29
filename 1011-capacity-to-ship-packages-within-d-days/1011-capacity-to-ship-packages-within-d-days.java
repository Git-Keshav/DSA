class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for(int weight : weights){
            high += weight;
            low = Math.max(low, weight);
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isValid(weights, days, mid)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isValid(int[] weights, int days, int capacity){
        int d = 1, currWeight = 0;
        for(int weight : weights){
            currWeight += weight;
            if(currWeight > capacity){
                currWeight = weight;
                d += 1;
            }
        }
        return d <= days;
    }
}