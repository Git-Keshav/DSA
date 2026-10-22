class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0; 
        int start = 0;
        int subArr = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i >= k-1){
                if(sum >= k * threshold){
                    subArr += 1;
                }
                sum -= arr[start];
                start += 1;
            }
        }
        return subArr;
    }
}