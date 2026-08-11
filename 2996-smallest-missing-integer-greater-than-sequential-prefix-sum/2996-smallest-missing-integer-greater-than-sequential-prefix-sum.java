class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        int a=nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]+1){
                a += nums[i];
            }
            else{
                break;
            }
        }
        HashSet<Integer> p=new HashSet<>();
        for(int num : nums){
            p.add(num);
        }
        while(p.contains(a)){
            a++;
        }
        return a;
    }
}