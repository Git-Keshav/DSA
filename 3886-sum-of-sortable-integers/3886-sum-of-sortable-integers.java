import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        // Find all divisors of n in O(sqrt(n))
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }

        long sum = 0;
        for (int k : divisors) {
            if (canSortWithK(nums, sortedNums, k, n)) {
                sum += k;
            }
        }

        return (int) sum;
    }

    private boolean canSortWithK(int[] nums, int[] sortedNums, int k, int n) {
        for (int start = 0; start < n; start += k) {
            // Check if nums[start ... start+k-1] is a valid cyclic shift 
            // of sortedNums[start ... start+k-1]
            if (!isCyclicShift(nums, sortedNums, start, k)) {
                return false;
            }
        }
        return true;
    }

    // A block is a cyclic shift of the sorted block if it matches 
    // starting from some offset inside the doubled sorted block
    private boolean isCyclicShift(int[] nums, int[] sortedNums, int start, int k) {
        // Find which offset in sortedNums matches the first element nums[start]
        for (int shift = 0; shift < k; shift++) {
            boolean matches = true;
            for (int i = 0; i < k; i++) {
                if (nums[start + i] != sortedNums[start + (shift + i) % k]) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                return true;
            }
        }
        return false;
    }
}