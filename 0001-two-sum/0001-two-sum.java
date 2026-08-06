class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            int s = target - nums[i];

            if(map.containsKey(s)){
                return new int[]{map.get(s), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}