class Solution {
    public int maximumLengthSubstring(String s) {
        int n = 0;
        int[] f = new int[256];
        int maxL = 0;

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            f[c]++;

            while(f[c] > 2){
                char ch = s.charAt(n);
                f[ch]--;
                n++;
            }

            int cur = i - n +1;
            maxL = Math.max(maxL, cur);
        }
        return maxL;
    }
}