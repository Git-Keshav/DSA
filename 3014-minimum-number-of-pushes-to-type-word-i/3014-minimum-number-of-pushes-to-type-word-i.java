class Solution {
    public int minimumPushes(String word) {
        int a = word.length();
        int quo = a / 8;
        int rem = a % 8;

        int totalP = 0;

        for(int i = 1; i <= quo; i++){
            totalP += 8*i;
        }
        totalP += rem * (quo +1);
        return totalP;
    }
}