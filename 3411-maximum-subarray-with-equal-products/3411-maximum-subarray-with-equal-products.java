class Solution {
    public int maxLength(int[] nums) {
        int result = 0;
        int n = nums.length;

        for(int i = 0; i< n; i++){
            long pVal = nums[i];
            long gVal = nums[i];
            long lVal = nums[i];

            for(int j= i+1; j <n; j++){
                pVal = pVal * nums[j];
                gVal = gcd(gVal, nums[j]);
                lVal = (lVal * nums[j]) / gcd(lVal, nums[j]);
                if(pVal > gVal *lVal){
                    break;
                }
                if(pVal == gVal * lVal){
                    result = Math.max(result, j -i + 1);
                }
            }
        }
        return result;
        
    }

    private long gcd(long a, long b){
        while(b != 0){
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}