class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int end = 0, n = nums.size();

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = nums.get(i - 1) + arr[i - 1];

        int minSum = Integer.MAX_VALUE;

        for (; end <= n; end++) {
            for (int j = Math.max(0, end - r); j <= end - l; j++) {
                int sum = arr[end] - arr[j];

                if (sum > 0)
                    minSum = Math.min(minSum, sum);
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}