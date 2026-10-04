class Solution {
    public boolean checkIfPangram(String sentence) {
        // Set<Character> set = new HashSet<>();
        
        // for (char c : sentence.toCharArray()) {
        //     set.add(c);
        // }
        
        // return set.size() == 26;


        boolean[] seen = new boolean[26];
        int count = 0;
        
        for (int i = 0; i < sentence.length(); i++) {
            int index = sentence.charAt(i) - 'a';
            if (!seen[index]) {
                seen[index] = true;
                count++;
            }
            if (count == 26) {
                return true;
            }
        }
        
        return count == 26;

    }
}