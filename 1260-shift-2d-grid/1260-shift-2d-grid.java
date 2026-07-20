class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int N = m *n;

        k %= N;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i< m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                int id = i*n+j;

                int o_id = (id - k + N) % N;

                int r = o_id /n;
                int c = o_id % n;

                row.add(grid[r][c]);
            }
            res.add(row);
        }
        return res;
    }
}