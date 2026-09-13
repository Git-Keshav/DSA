class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> onesImg1 = new ArrayList<>();
        List<int[]> onesImg2 = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) onesImg1.add(new int[]{r, c});
                if (img2[r][c] == 1) onesImg2.add(new int[]{r, c});
            }
        }

        Map<String, Integer> vectorCount = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : onesImg1) {
            for (int[] p2 : onesImg2) {
                
                int x = p2[0] - p1[0];
                int y = p2[1] - p1[1];
                String vector = x + "," + y;

                int curOverlap = vectorCount.getOrDefault(vector, 0) + 1;
                vectorCount.put(vector, curOverlap);
                
                maxOverlap = Math.max(maxOverlap, curOverlap);
            }
        }
        return maxOverlap;

    }
}