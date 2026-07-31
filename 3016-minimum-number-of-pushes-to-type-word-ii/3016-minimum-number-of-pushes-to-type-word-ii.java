class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : freq){
            if(cnt > 0){
                maxHeap.offer(cnt);
            }
        }

        int totalPus = 0;
        int mapCnt = 0;

        while(!maxHeap.isEmpty()){
            int CurFreq = maxHeap.poll();

            int pushNeed = (mapCnt / 8)+ 1;
            totalPus += CurFreq * pushNeed;

            mapCnt++;
        }
        return totalPus;
    }
}