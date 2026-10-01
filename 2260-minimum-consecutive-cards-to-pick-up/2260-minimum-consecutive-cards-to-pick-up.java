class Solution {
    public int minimumCardPickup(int[] cards) {
        int start = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;

        for(int end = 0; end < cards.length; end++){
            int cur = cards[end];
            freqMap.put(cur, freqMap.getOrDefault(cur, 0) + 1);
            while(freqMap.get(cur) == 2){
                minLen = Math.min(minLen, end - start + 1);
                freqMap.put(cards[start], freqMap.get(cards[start])-1);
                start += 1;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
