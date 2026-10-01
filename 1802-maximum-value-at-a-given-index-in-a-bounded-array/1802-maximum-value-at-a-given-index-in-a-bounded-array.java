class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long low = 1;
        long high = maxSum;
        long result = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isValid(mid, n, index, maxSum)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) result;
    }

    private boolean isValid(long mid, int n, int index, int maxSum) {
        long leftCount = index;
        long rightCount = n - 1 - index;
        long totalSum = mid + getMinSum(leftCount, mid - 1) + getMinSum(rightCount, mid - 1);
        return totalSum <= maxSum;
    }

    private long getMinSum(long count, long value) {
        if (count == 0)
            return 0;

        if (value >= count) {
            return count * (value + (value - count + 1)) / 2;
        } else {
            long sumOfSequence = value * (value + 1) / 2;
            long remainingOnes = count - value;
            return sumOfSequence + remainingOnes;
        }
    }
}