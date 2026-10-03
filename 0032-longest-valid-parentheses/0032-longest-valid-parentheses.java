class Solution {
    public int longestValidParentheses(String s) {
        int open_count = 0;
        int close_count = 0;
        int max_len = 0;

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                open_count++;
            }else {
                close_count++;
            }

            if(open_count == close_count){
                max_len = Math.max(max_len, 2 * close_count);
            }else if(close_count > open_count){
                open_count = 0;
                close_count = 0;
            }
        }

        open_count = 0;
        close_count = 0;

        for(int i = s.length() -1 ; i >= 0; i--){
            if(s.charAt(i) == '('){
                open_count++;
            }else{
                close_count++;
            }
            if(open_count == close_count){
                max_len = Math.max(max_len, 2 * open_count);
            }else if(open_count > close_count){
                open_count = 0;
                close_count = 0;
            }
        }
        return max_len;
    }
}