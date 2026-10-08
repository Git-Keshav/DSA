class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int rem = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (rem > 0) {
                    ans.append(ch);
                }
                rem++;
            } else {
                rem--;
                if (rem > 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}