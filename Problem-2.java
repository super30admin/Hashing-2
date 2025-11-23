// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Compute a running prefix sum where 0 becomes −1 and 1 becomes +1.
// If the same prefix appears again, the subarray between those two positions has equal 0s and 1s.
// Use a hashmap to store the first occurrence of each prefix sum and track the longest valid subarray.

class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int result = 0;
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count -= 1;
            else count += 1;

            if (firstOccurrence.containsKey(count)) {
                result = Math.max(result, i + 1 - firstOccurrence.get(count));
            } else {
                firstOccurrence.put(count, i + 1);
            }
        }

        return result;
    }
}
