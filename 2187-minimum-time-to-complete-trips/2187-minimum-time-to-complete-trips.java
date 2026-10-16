class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int minTime = Integer.MAX_VALUE;
        for (int i : time) {
            minTime = Math.min(minTime, i);
        }
        long start = 1;
        long end = (long)minTime * totalTrips;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isValid(time, totalTrips, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isValid(int[] time, int totalTrips, long mid) {
        long sum = 0;

        for (int i : time) {

            sum += mid / i;

        }
        return sum >= totalTrips;
    }
}