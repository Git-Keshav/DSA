class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Store knowledge in a HashMap for O(1) lookups
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;

        // Step 2: Traverse the string
        while (i < n) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // Find the closing bracket
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                
                // Extract the key between '(' and ')'
                String key = s.substring(i + 1, j);
                
                // Append the value from map or '?' if not found
                sb.append(map.getOrDefault(key, "?"));
                
                // Move the pointer past the closing bracket
                i = j + 1;
            } else {
                // Normal character outside brackets
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}