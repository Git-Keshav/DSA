class Solution {
    public int maxVowels(String s, int k) {
        int start = 0, end = 0, sum = 0;
        int maxVowels = 0;
        
        for (end = 0; end < s.length(); end++) {
            if (isVowel(s.charAt(end))) {
                sum += 1;
            }
            
            if (end >= k - 1) {
                maxVowels = Math.max(maxVowels, sum);
                
                if (isVowel(s.charAt(start))) {
                    sum -= 1;
                }
                start += 1;
            }
        } 
        return maxVowels;
    }
    
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}