class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> fr = new HashMap<>();

        int l = 0;
        int maxL = 0;

        for(int r = 0; r < nums.length; r++){
            int curNum = nums[r];

            fr.put(curNum, fr.getOrDefault(curNum, 0) + 1);

            while(fr.get(curNum) > k){
                int lNum = nums[l];
                fr.put(lNum, fr.get(lNum) - 1);
                l++;
            }
            maxL = Math.max(maxL, r - l +1);
        }

        return maxL;
    }
}