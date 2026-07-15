class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] index = new int[nums.length][2];

        for(int k = 0; k < nums.length; k++){
            index[k][0] = nums[k];
            index[k][1] = k;
        }

        Arrays.sort(index, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = index.length -1;

        while(i < j){
            int sum = index[i][0] + index[j][0];

            if(sum == target){
                return new int[]{index[i][1], index[j][1]};

            }else if(sum > target){
                j -= 1;
            }else{
                i += 1;
            }
        }
        return new int[]{};
    }
}