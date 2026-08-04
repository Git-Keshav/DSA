class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> miss = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length -1; i++){
            for(int j = nums[i] +1; j < nums[i+1]; j++){
                miss.add(j);
            }
        }
        return miss;
    }    
}