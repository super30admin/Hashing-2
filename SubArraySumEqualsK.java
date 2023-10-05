// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Pattern: Sub-Array Sum
 * i.e. if for an array[n] => sum of array[0, 2] = x; sum of array[0, 4] = z; =>
 * sum of array[2, 4] = z - x;
 * 
 * Decode the question:
 * SubArray Sum equals K
 * 
 * Brute:
 * a. Look for all SubArrays = O(n^2)
 * b. Pick the SubArray with sum K
 * TC: O(n^2)
 * SC: O(1)
 * 
 * Optimization:
 * To transform O(n^2) to O(n) => Hasshing with Running Sum
 * 
 * For calculating the sum of each subarray, I redo what I've already computed
 * for a previous subarray and check if it is equal to k.
 * whereas, I can subtract the prefix sum from the running (current) sum and
 * check if it is equla to k
 * 
 * it means we need to store the prefix sum, so that we can find out if it
 * exists such that (running sum - k) == prefix Sum
 * 
 * to access the prefix sum in O(1) == Hashing
 * 
 * Question asks for the count of such subarrays => map prefix sum to the count
 * (# of times it has occurred)
 * 
 * Special case:
 * {7}, k = 7 => ans should be 1
 * 
 * prefix sum map = {}
 * 
 * running sum - k => 7 - 7 = 0 => check the count from prefix sum map such that
 * it contains key 0
 * 
 * since, prefix sum map is empty => ans = 0
 * 
 * hence, base case == if entire array sum == k
 * prefix sum map = {0, 1}
 * 
 * TC: O(n)
 * SC: O(n)
 */
public class SubArraySumEqualsK {

    /**
     * TC: O(n^2)
     * SC: O(1)
     */
    public int subarraySum_brute(int[] nums, int k) {
        int count = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[i];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            }

            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}