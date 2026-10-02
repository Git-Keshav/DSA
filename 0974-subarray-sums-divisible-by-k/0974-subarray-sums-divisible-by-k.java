class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] frq = new int[k];
        frq[0] = 1;
        
        int sum = 0;
        int cnt = 0;
        
        for (int num : nums) {
            sum += num;
            int rem = sum % k;
            
            if (rem < 0) {
                rem += k;
            }
            cnt += frq[rem];
            frq[rem]++;
        }
        
        return cnt;
    
    }
}