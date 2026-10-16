class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start = 1;
        int end = 0;
        for (int i : candies) {
            end = Math.max(i, end);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(candies, k, mid)) {
        
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private boolean isValid(int[] candies, long k, int mid) {
        long cnt = 0;
        for (int i : candies) {
            cnt += i / mid;
        }
        return cnt >= k;
    }
}