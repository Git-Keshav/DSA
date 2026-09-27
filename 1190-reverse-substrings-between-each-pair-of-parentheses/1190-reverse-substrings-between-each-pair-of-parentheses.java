class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> ins_Val = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();

        for(char c: s.toCharArray()){
            if(c == '('){
                ins_Val.push(curr);
                curr = new StringBuilder();
            }else if(c == ')'){
                curr.reverse();
                StringBuilder paren = ins_Val.pop();
                paren.append(curr);
                curr = paren;
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}