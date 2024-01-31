// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/** Your code here along with comments explaining your approach:*
* Using running sum property: for index i and j such that j > i.
* Sum(i, j) = Sum(0, j) - Sum(0, i)
* If sum of two sub arrays((0, i) and (0, j)) is same; that means the sum of subarray(i, j) = 0 (balanced)
* Using a hashmap to keep track of last occurence of sum and updating res.
*/

import java.util.HashMap;
import java.util.Map;

class Problem2 {
    public int findMaxLength(int[] nums) {
        // as we need the max length of a subarray; we store the mapping values as
        // first occurences
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int runningSum = 0;
        int res = 0;

        /*
         * Explanation for using dummy node:
         * to handle sub arrays starting from the 0th index; either do this or
         * whenever you encounter 0 in the running sum, get the length from the
         * beginning. this is required because if you encounter a 0 in the running sum,
         * this means that from beginning to the current index, the sum is 0. So, to
         * make sure the length is calculated correctly (which is from the beginning),
         * this dummy condition is added.
         */
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                runningSum -= 1;
            } else {
                runningSum += 1;
            }
            if (map.containsKey(runningSum)) {
                // difference of the indexes where values are same = length of balanced subarray
                res = Math.max(res, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        return res;
    }
}