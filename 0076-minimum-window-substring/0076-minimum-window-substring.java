class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int start = 0, end = 0;
        int len = Integer.MAX_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        int window = 0;

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int cnt = 0;
        for (; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    cnt += 1;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while (cnt == t.length()) {
                if (end - start + 1 < len) {
                    len = end - start + 1;
                    window = start;
                }
                char left = s.charAt(start);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0) {
                        cnt--;
                    }
                }
                start++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(window, window + len);
    }
}