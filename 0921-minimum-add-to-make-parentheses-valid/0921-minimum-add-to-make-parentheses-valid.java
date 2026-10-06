class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int matchedCount = 0;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    matchedCount += 2;
                }
            } else {
                stack.push(c);
            }
        }
        return s.length() - matchedCount;
    }
}