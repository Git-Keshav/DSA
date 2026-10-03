class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                for (int r = -1; r <= 1; r++) {
                    for (int c = -1; c <= 1; c++) {
                        int nx = i + r;
                        int ny = j + c;

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            sum += img[nx][ny];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}