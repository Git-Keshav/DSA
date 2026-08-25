class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> l = new HashSet<>();
        for(int n : nums) {
            l.add(n);
        }

        int mul = k;
        while (l.contains(mul)) {
            mul += k;
        }
        return mul;
    }
}