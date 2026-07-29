class Solution {
    private static final long LIMIT = 1_000_001L;
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        int[] halfCnt = new int[26];
        int len = 0;
        char midCh = 0;

        for(int i = 0; i< 26; i++){
            halfCnt[i] = freq[i] / 2;
            len += halfCnt[i];

            if(freq[i] % 2 != 0){
                midCh = (char) ('a' + i);
            }
        }

        if(CountWays(halfCnt,len) < k){
            return "";
        }

        StringBuilder leftHalf = new StringBuilder();

        for(int pos = 0; pos < len; pos++){
            for(int ch = 0; ch < 26; ch++){
                if(halfCnt[ch] == 0 ) continue;

                halfCnt[ch]--;

                long ways = CountWays(halfCnt, len - pos -1);

                if(ways >= k){
                    leftHalf.append((char) ('a' + ch));
                    break;
                }

                k -= ways;
                halfCnt[ch]++;
            }
        }

        StringBuilder res = new StringBuilder(leftHalf);
        if(midCh != 0){
            res.append(midCh);
        }
        res.append(new StringBuilder(leftHalf).reverse());

        return res.toString();
    }

    private long CountWays(int[] counts, int totalLength){
        long ways = 1;
        int rema = totalLength;

        for(int i = 0; i < 26; i++){
            int count = counts[i];
            if(count == 0) continue;

            for(int j = 1; j <= count; j++){
                ways = ways *(rema - count + j)/j;
                if(ways > LIMIT){
                    return LIMIT;
                }
            }
            rema -= count;
        }
        return ways;
    }
}