// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : finding the balanced freq and deducing the problem to subarray sum equals k pattern

/**
 * Pattern: SubArray Sum Equals K
 * 
 * Brute:
 * a. Find all subarrays
 * b. For each subarray, check the frequency of 0 and 1 using 2 pointers for
 * each
 * TC: O(n^2)
 * SC: O(1)
 * 
 * Optimization: from O(n^2) to O(n)
 * For each subarray, we're doing a recomputation of frequency, which has
 * already been found in the previous subarray of length greater than the
 * current subarray
 * 
 * Better to hash the prefix subarray frequency to access it in O(1)
 * 
 * hence, a pattern deduced => hashing + running sum
 * 
 * now, what to hash such that it is of the form of sub array sum equals k (z -
 * k = x)
 * 
 * what is the frequency of the balance subarray (k) ?
 * freq (1) = freq (0) => freq(1) - freq(0) = 0 => x - (x) = 0
 * i.e. +1 for 1, -1 for 0
 * 
 * if prefixFreq == runningFreq exists at an earlier index
 * it means we've found a balanced subarray
 * 
 * map the prefix frequency balance to the index
 * such that balanced length = running index - prefix index
 * 
 * NOTE: we need to find the max length of the balance subarray => if
 * runningFreq exists, don't update it in the map => else it will result into a
 * subarray of min. length
 * 
 * Special Case:
 * if the complete array is balanced
 * [1, 0]
 * 
 * at index 1
 * prefixFreqMap = {1, 0}
 * runningFreq = 1 - 1 = 0
 * 
 * since, prefixFreqMap doesn't contains 0 as a prefixFreq => answer = 0
 * 
 * so base case:
 * prefixFreqMap = {0, -1} i.e. entire array as balanced till -1, such that
 * n-1-(-1) = n == length of the complete array
 */
public class BalancedSubarray {

    /**
     * TLE
     * 
     * TC: O(n^2)
     * SC: O(1)
     */
    public int findMaxLength_brute(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int freq = 0;
            int length = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    freq++;
                } else {
                    freq--;
                }
                if (freq == 0) {
                    length = j - i + 1;
                    max = Math.max(max, length);
                }
            }
        }
        return max;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0, -1);

        int freq = 0;
        int length = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                freq++;
            } else {
                freq--;
            }

            if (prefixFreq.containsKey(freq)) {
                length = i - prefixFreq.get(freq);
                max = Math.max(max, length);
            } else {
                prefixFreq.put(freq, i);
            }
        }

        return max;
    }
}