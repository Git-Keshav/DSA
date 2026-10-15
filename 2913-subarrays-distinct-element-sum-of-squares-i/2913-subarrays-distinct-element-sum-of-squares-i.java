class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;

        for (int start = 0; start < n; start++) {
            Set<Integer> distinct = new HashSet<>();

            for (int end = start; end < n; end++) {
                distinct.add(nums.get(end));
                int count = distinct.size();
                totalSum += count * count;
            }
        }

        return totalSum;

    }
}