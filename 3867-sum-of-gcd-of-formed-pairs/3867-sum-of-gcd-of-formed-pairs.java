class Solution {

    private int  gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] pregcd = new int[n];
        int currentMax = 0;

        for (int i = 0; i < n; i++) {
            currentMax =  Math.max(currentMax, nums[i]);
            pregcd[i] = gcd(nums[i], currentMax);
        }

        Arrays.sort(pregcd);

        long totalSum = 0;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            totalSum += gcd(pregcd[i], pregcd[j]);
            i++;
            j--;
        }

        return totalSum;
    }
}