class Solution {
    public String smallestPalindrome(String s) {
        int a = s.length();
        int[] cnt = new int[26];

        for(char ch : s.toCharArray()){
            cnt[ch - 'a']++;
        }
        int fHalf = 0;
        int lHalf = a-1;
        char[] res = new char[a];

        for(int i = 0; i< 26; i++){
            if(cnt[i] % 2 != 0){
                res[a / 2] = (char)(i + 'a');
                cnt[i]--;
            }
        
            while(cnt[i] > 0){
                res[fHalf++] = (char) (i + 'a');
                res[lHalf--] = (char) (i + 'a');
                cnt[i] -= 2;
            }
        }
        return new String(res);
    }
    
}