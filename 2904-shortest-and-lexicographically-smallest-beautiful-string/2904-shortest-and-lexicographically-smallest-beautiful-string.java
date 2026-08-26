class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = n + 1;
        String res = "";
        
        int countOnes = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            
            while (countOnes > k || (countOnes == k && s.charAt(left) == '0')) {
                if (s.charAt(left) == '1' && countOnes == k) {
                }
                if (s.charAt(left) == '1') {
                    if (countOnes == k) {
                    }
                }
                if (s.charAt(left) == '1') {
                }
                break; 
            }
            
            while (countOnes > k) {
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }
            
            while (countOnes == k && s.charAt(left) == '0') {
                left++;
            }
            
            if (countOnes == k) {
                String candidate = s.substring(left, right + 1);
                int currLen = candidate.length();
                
                if (currLen < minLen) {
                    minLen = currLen;
                    res = candidate;
                } else if (currLen == minLen) {
                    if (res.equals("") || candidate.compareTo(res) < 0) {
                        res = candidate;
                    }
                }
            }
        }
        
        return res;
    }
}