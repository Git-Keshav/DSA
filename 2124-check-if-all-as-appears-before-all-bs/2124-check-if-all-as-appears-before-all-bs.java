class Solution {
    public boolean checkString(String s) {
        boolean cntB = false;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                cntB = true;
            } else if (ch == 'a' && cntB) {
                return false;
            }
        }
        return true;
    }
}