// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/** Your code here along with comments explaining your approach:*
* Using running sum property: for index i and j such that j > i.
* Sum(i, j) = Sum(0, j) - Sum(0, i)
* If complement (sum - k) of Sum(i, j) has been traversed (stored in map), that means there is a subarray(i, j) with sum k.
* The hashmap stores the number of occurences of each sum
*/

import java.util.HashMap;
import java.util.Map;

class Problem1 {
    public int subarraySum(int[] nums, int k) {
        int runningSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // edge case: if the subarray starts from the beginning
        // if a subarray is starting from the beginning and has sum = k
        // this can also be possible if the complement of that subarray is 0 (k-k)

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int complement = runningSum - k;
            if (map.containsKey(complement)) {
                res += map.get(complement);
            }
            // initialize key value to 0 if it doesnt exist and then add 1
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        return res;
    }
}