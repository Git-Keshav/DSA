class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

    int[] minL = new int[n];
        int min_far = Integer.MAX_VALUE;
        
        int ans = Integer.MAX_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

        map.put(currentSum, i);

        if (map.containsKey(currentSum - target)) {
                int prevIndex = map.get(currentSum - target);
                int length = i - prevIndex;

                if (prevIndex > -1 && minL[prevIndex] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, length + minL[prevIndex]);
                }
                min_far = Math.min(min_far , length);
            }
            minL[i] = min_far  ;

            
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}