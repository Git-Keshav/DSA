class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(dist, hour, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low == 10000001) ? -1 : low;
    }

    private boolean isValid(int[] dist, double hour, int speed) {
        double noh =0;
        for(int i = 0; i < dist.length -1; i++){
            noh += Math.ceil((double)dist[i] / (double)speed);
        }
        noh += (double)dist[dist.length -1] / (double)speed;

        return noh <= hour;
    }
}