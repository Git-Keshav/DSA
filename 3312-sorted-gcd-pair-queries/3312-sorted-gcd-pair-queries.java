class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int  n = 0;
        for(int num: nums){
            n = Math.max(n, num);
        }

        int[] freq = new int[n + 1];
        for (int num : nums) {
            freq[num]++;
        }

        long[] exactCount = new long[n + 1];


        for(int i = n; i >= 1; i--){
            long cnt = 0;
            for(int j = i; j <= n; j += i){
                cnt += freq[j];
            }

            long totalPairsWithGAsDivisor = cnt * (cnt - 1)/2;

            for (int j = 2 * i; j <= n; j += i){
                totalPairsWithGAsDivisor -= exactCount[j];
            }
            exactCount[i] = totalPairsWithGAsDivisor;
        }

        int[] sortedGcds = new int[n + 1];
        long currentIdx = 0;
        for (int i = 1; i <= n; i++){
            if (exactCount[i] > 0){

            }
        }
        long[] cumulativeCount = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            cumulativeCount[i] = cumulativeCount[i - 1] + exactCount[i]; 
        }
        

        int[] answer = new int[queries.length];
        for(int x = 0; x < queries.length; x++){
            long target = queries[x] + 1;

            int low = 1, high = n;
            int ans = n;
            while (low <= high) {
                int mid = low +(high - low) / 2;
                if (cumulativeCount[mid] >= target) {
                    ans = mid;
                    high = mid -1 ;
                } else {
                    low = mid + 1;
                }
            }
            answer[x] = ans;
        }
        return answer;
    }
}