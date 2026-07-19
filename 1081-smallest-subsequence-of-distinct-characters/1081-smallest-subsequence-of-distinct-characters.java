class Solution {
    public String smallestSubsequence(String s) {
        int[] lastO = new int [26];
        boolean[] seen = new boolean[26];

        for(int i = 0; i<s.length(); i++){
            lastO[s.charAt(i) - 'a'] = i;
        }
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);

            if(seen[c - 'a']){
                continue;
            }
            while (stack.length() > 0 && c < stack.charAt(stack.length() - 1) && lastO[stack.charAt(stack.length() - 1) - 'a'] > i){
                char remChar = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                seen[remChar - 'a'] = false;
            }
            stack.append(c);
            seen[c - 'a'] = true;
        }
        return stack.toString();
    }
}