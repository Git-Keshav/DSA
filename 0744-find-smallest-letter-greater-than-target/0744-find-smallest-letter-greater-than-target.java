class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        if (target >= letters[high]) {
            return letters[0];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return letters[low];
    }
}