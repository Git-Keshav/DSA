class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] f = new int[26];
        int[] l = new int[26];

        Arrays.fill(f, -1);
        for(int i = 0; i< n;  i++){
            int c = s.charAt(i) - 'a';
            if(f[c] == -1 ) f[c] = i;
            l[c] = i;
        }
        List<int[]> intervals = new ArrayList<>();

        for(int c = 0; c<26; c++){
            if(f[c] == -1) continue;

            int left = f[c];
            int right = l[c];
            boolean valid = true;

            for(int i = left; i<= right; i++){
                int x = s.charAt(i) - 'a';

                if(f[x] < left){
                    valid = false;
                    break;
                }
                right = Math.max(right, l[x]);
            }
            if(valid){
                intervals.add(new int[]{left, right});
            }
        }
        intervals.sort((a,b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();
        int end = -1;

        for(int[] interval : intervals){
            if(interval[0] > end){
                ans.add(s.substring(interval[0], interval[1] + 1));
                end = interval[1];
            }
        }
        return ans;
        

    }
}