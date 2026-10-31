class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1000000007;

        int m = grid.length;
        int n = grid[0].length;

        int[][][] field = new int[m][n][2];
        field[0][0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (grid[i - 1][j] == 0) {
                        field[i][j][0] =
                            (field[i - 1][j][0] + field[i - 1][j][1]) % MOD;
                    } else {
                        field[i][j][0] = field[i - 1][j][1];
                    }
                }

                if (j > 0) {
                    if (grid[i][j - 1] == 0) {
                        field[i][j][1] =
                            (field[i][j - 1][0] + field[i][j - 1][1]) % MOD;
                    } else {
                        field[i][j][1] = field[i][j - 1][0];
                    }
                }
            }
        }

        return (field[m - 1][n - 1][0] + field[m - 1][n - 1][1]) % MOD;
    }
}