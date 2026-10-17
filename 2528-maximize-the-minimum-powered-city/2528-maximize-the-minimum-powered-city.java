class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] diff = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);

            diff[left] += stations[i];
            diff[right + 1] -= stations[i];
        }

        long[] power = new long[n];
        long cur = 0;
        long minVal = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            power[i] = cur;
            minVal = Math.min(minVal, power[i]);
        }

        long start = minVal;
        long end = minVal + k;
        for (int x : stations) {
            end += x;
        }

        long ans = start;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isValid(power, r, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(long[] power, int r, int k, long target) {
        int n = power.length;
        long[] diffAdd = new long[n + 1];
        long addedSoFar = 0;
        long rem = k;

        for (int i = 0; i < n; i++) {
            addedSoFar += diffAdd[i];
            long currentPower = power[i] + addedSoFar;

            if (currentPower < target) {
                long need = target - currentPower;
                if (need > rem) {
                    return false;
                }
                rem -= need;
                addedSoFar += need;

                int pos = Math.min(n - 1, i + r);
                int expireIdx = pos + r + 1;
                if (expireIdx <= n) {
                    diffAdd[expireIdx] -= need;
                }
            }
        }

        return true;
    }
}