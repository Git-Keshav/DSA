class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans, String curStr, int open_count, int close_count, int max_depth) {
        if (curStr.length() == max_depth * 2) {
            ans.add(curStr);
            return ;
        }
        if (open_count < max_depth) {
            dfs(ans, curStr + "(", open_count + 1, close_count, max_depth);
        }
        if (close_count < open_count) {
            dfs(ans, curStr + ")", open_count, close_count + 1, max_depth);
        }
    }
}