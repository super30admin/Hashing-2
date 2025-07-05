
/* 560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2


 TimeComplexity:-O(n)
 SpaceComplexity:-O(n)
 Approach:- Used a running sum rSum to track the prefix sum. Used a HashMap to store how many times each rSum has occurred. At each index if (rSum - k) exists in the map, it means a subarray summing to k ends here → add its count.update the map with the current rSum.
*/
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Base check: if array is null or empty, return
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int rSum = 0;// running Sum
        int count = 0;// count for total number of subarrays whose sum equals to k
        HashMap<Integer, Integer> map = new HashMap<>();// HashMap to store frequency of running sums
        map.put(0, 1);// base case: sum 0 has occurred once (helps when rSum == k)
        // traverse array
        for (int i = 0; i < nums.length; i++) {
            // update the running sum
            rSum = rSum + nums[i];
            // Check if (rSum - k) exists in map
            // If yes, it means there's a subarray ending here that sums to k
            if (map.containsKey(rSum - k)) {
                count = count + map.get(rSum - k);
            }
            // Update map with the current rSum
            // If it already exists, increment its frequency
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        // Return total count of subarrays summing to k
        return count;
    }
}