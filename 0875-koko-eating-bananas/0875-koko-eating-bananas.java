class Solution {
    public int minEatingSpeed(int[] nums, int k) {
        int start = 1, end = 0;
        for (int i : nums) {
            end = Math.max(end, i);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, k, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isValid(int[] nums, int k, int mid) {
        long nhr = 0;

        for (int i : nums) {
            nhr += (i + mid - 1L) / mid;
        }

        return nhr <= k;
    }
}