class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int rMin = matrix[i][0];
            int rMinIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < rMin) {
                    rMin = matrix[i][j];
                    rMinIndex = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][rMinIndex] > rMin) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(rMin);
                break;
            }
        }

        return result;
    }
}