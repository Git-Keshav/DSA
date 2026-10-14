class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, windowEnd = 0, length = 0;

        HashMap<Character, Integer> indexMap = new HashMap<>();

        for(; windowEnd < s.length(); windowEnd += 1){
            char currChar = s.charAt(windowEnd);

            if(indexMap.containsKey(currChar)){
                windowStart = Math.max(windowStart, indexMap.get(currChar) +1);

            }

            length = Math.max(length, (windowEnd - windowStart + 1));
            indexMap.put(currChar, windowEnd);
        }
        return length;
    }
}