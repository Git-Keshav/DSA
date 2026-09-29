class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        Set<Integer>[][] dp = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }

        int startOpen = (grid[0][0] == '(') ? 1 : -1;
        if (startOpen >= 0) {
            dp[0][0].add(startOpen);
        } else {
            return false;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c].isEmpty()) continue;

                char currentChar = grid[r][c];
                if (r + 1 < m) {
                updateNext(dp[r + 1][c], dp[r][c], grid[r + 1][c]);
                }
                if (c + 1 < n) {
                    updateNext(dp[r][c + 1], dp[r][c], grid[r][c + 1]);
                }
            }
        }
        return dp[m - 1][n - 1].contains(0);
    }

    private void updateNext(Set<Integer> nextSet, Set<Integer> currSet, char nextChar) {
        int delta = (nextChar == '(') ? 1 : -1;
        for (int open : currSet) {
            int newOpen = open + delta;
            if (newOpen >= 0) {
                nextSet.add(newOpen);
            }
        }
    }
    
}