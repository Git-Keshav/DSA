class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int maxcnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
                maxcnt = Math.max(maxcnt, cnt);
            } else if (c == ')') {
                cnt--;
            }
        }
        return maxcnt;
            
    }
}