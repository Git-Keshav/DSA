class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isValid(int[] nums, int k, int sum) {
        int numOfSplit = 1;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;

            if (currSum > sum) {
                numOfSplit += 1;
                currSum = num;
            }

        }
        return numOfSplit <= k;
    }
}