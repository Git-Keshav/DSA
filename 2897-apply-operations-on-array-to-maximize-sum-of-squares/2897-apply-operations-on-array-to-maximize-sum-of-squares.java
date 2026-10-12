class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bit_Count = countBits(nums);
        long[] res_Num = reconstructTopNumbers(bit_Count, k);
        return calculateSumOfSquares(res_Num);
    }

    private int[] countBits(List<Integer> nums) {
        int[] bit_Count = new int[30];
        for(int num : nums) {
            for(int i = 0; i < 30; i++) {
                if(((num >> i) & 1) == 1) {
                    bit_Count[i]++;
                }
            }
        }
        return bit_Count;
    }

    private long[] reconstructTopNumbers(int[] bit_Count, int k) {
        long[] res_Num = new long[k];
        for(int i = 29; i >= 0; i--) {
            int count = bit_Count[i];
            for (int j = 0; j < Math.min(count, k); j++) {
                res_Num[j] |= (1L << i);
            }
        }
        return res_Num;
    }

    private int calculateSumOfSquares(long[] res_Num) {
        long totalSum = 0;
        long MOD = 1000000007;
        
        for(long num : res_Num) {
            totalSum = (totalSum + (num * num) % MOD) % MOD;
        }
        return (int) totalSum;
    }

}