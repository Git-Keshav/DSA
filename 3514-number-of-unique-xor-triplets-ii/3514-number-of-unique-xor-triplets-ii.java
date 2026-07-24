class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxE = 0;

        for(int num : nums){
            maxE = Math.max(maxE, num);
        }
        int T = 1;
        while(T <= maxE){
            T <<= 1;
        }
        boolean[] s1 = new boolean[T];
        boolean[] s2 = new boolean[T];

        for(int i = 0; i< T; i++){
            for(int j = i; j <n; j++){
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        for(int i = 0; i < T; i++){
            if(s1[i]){
                for(int num : nums){
                    s2[i ^ num] = true;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < T; i++){
            if(s2[i]){
                cnt++;
            }
        }
        return cnt;
    }
}