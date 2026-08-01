class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        if(n % 2 == 0){
            return true;
        }
        int[] prevCalc = new int[n];
        for(int i = 0; i < n; i++){
            prevCalc[i] = nums[i];
        }

        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;

                prevCalc[i] = Math.max(nums[i] - prevCalc[i + 1], nums[j] - prevCalc[i]);
            }
        }

        return prevCalc[0] >= 0;
    }
}