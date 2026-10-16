class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int ele : bloomDay) {
            end = Math.max(end, ele);
            start = Math.min(start, ele);
        }
        while (start <= end) {
            int mid = start + (end - start) /2;

            if (isValid(bloomDay, k, m, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isValid(int[] bloomDay, int k, int m, int mid) {
        int cnt = 0;
        int flowerCnt = 0;

        for (int i : bloomDay) {
            if (i <= mid) {
                flowerCnt++;

                if (flowerCnt == k) {
                    cnt++;
                    flowerCnt = 0;
                }

            } else {
                flowerCnt = 0;
            }
        }

        return cnt >= m;
    }

}