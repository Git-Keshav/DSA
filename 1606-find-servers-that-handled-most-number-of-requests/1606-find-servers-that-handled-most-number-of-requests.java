class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> free = new PriorityQueue<>();

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[k];
        for (int i = 0; i < k; i++) {
            free.offer(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int currentTime = arrival[i];

            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                int[] finished = busy.poll();
                int serverId = finished[1];
                
                int distance = (serverId - (i % k) + k) % k;
                free.offer(i + distance);
            }

            if (free.isEmpty()) {
                continue;
            }
            int turn = free.poll();
            int serverId = turn % k;

            count[serverId]++;
            busy.offer(new int[]{currentTime + load[i], serverId});
        }
        int maxCount = 0;
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxCount) {
                result.add(i);
            }
        }
        return result;
    }

}