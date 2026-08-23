class Solution {
    public boolean sumGame(String num) {
        int n= num.length();
        
        int s1 = 0;
        int q1 = 0;
        for (int i= 0; i< n/2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q1++; 
            }else {
                s1 += c - '0';
            }
        }

        int s2= 0;
        int q2 = 0;
        for (int i= n/2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q2++;
            }else {
                s2 += c - '0';
            }
        }
        if ((q1 + q2) % 2 != 0) {
            return true;
        }
        return (s2 - s1) != (q1 - q2) /2 * 9;
    }
}