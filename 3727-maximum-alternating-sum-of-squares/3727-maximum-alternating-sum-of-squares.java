class Solution {
    private final Random random = new Random();

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length, h = n / 2;
        long[] squ = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            squ[i] = (long) nums[i] * nums[i];
            total += squ[i];
        }
        select(squ, h);
        long small = 0;
        for (int i = 0; i < h; i++) small += squ[i];
        return total - 2 * small;
    }

    private void select(long[] a, int k) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            long pivot = a[low + random.nextInt(high - low + 1)];
            int lt = low, i = low, gt = high;
            while (i <= gt) {
                if (a[i] < pivot) swap(a, lt++, i++);
                else if (a[i] > pivot) swap(a, i, gt--);
                else i++;
            }
            if (k < lt) high = lt - 1;
            else if (k > gt + 1) low = gt + 1;
            else return;
        }
    }

    private void swap(long[] a, int i, int j) {
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}