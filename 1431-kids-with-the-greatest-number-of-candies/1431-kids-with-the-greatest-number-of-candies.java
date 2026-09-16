class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int cand = 0;
        for (int candy : candies) {
            if (candy > cand) {
                cand = candy;
            }
        }

        List<Boolean> ans = new ArrayList<>(candies.length);
        for (int candy : candies) {
            ans.add(candy + extraCandies >= cand);
            }
        return ans;
    }
}