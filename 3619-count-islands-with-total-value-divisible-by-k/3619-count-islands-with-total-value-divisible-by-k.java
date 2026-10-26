class Solution {
    public int countIslands(int[][] grid, int k) {
        int gridLen = grid.length;
        int rowLen = grid[0].length;

        int ans = 0;

        for(int i = 0; i< gridLen; i++){
            for(int j = 0; j < rowLen; j++){
                if(grid[i][j] > 0){
                    long sum = sumOfGrid(grid, i, j);
                    if(sum % k == 0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private long sumOfGrid(int[][] grid, int i, int j){
        int gridLen = grid.length;
        int rowLen = grid[0].length;

        if(i < 0 || i >= gridLen || j < 0 || j >= rowLen || grid[i][j] == 0){
            return 0;
        }
        long sum = grid[i][j];
        grid[i][j] = 0;

        sum += sumOfGrid(grid, i +1, j);
        sum += sumOfGrid(grid, i -1, j);
        sum += sumOfGrid(grid, i , j + 1);
        sum += sumOfGrid(grid, i, j - 1);
        return sum;
    }

}