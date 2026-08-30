class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minInd= 0;
        int maxInd= 0;
            
        for(int i = 0; i<n; i++){
            if(nums[i] < nums[minInd]) minInd = i;
            if(nums[i] > nums[maxInd]) maxInd = i;
        }
        int l = Math.min(minInd, maxInd);
        int r = Math.max(minInd, maxInd);

        int fr = r + 1;
        int ba = n - l;
        int bo = (l + 1) + (n - r);

        return Math.min(fr , Math.min(ba, bo));

    }
}