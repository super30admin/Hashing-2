// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use a hashmap to store the cumulative sum and its index. We will iterate through the array and calculate the cumulative sum. If the cumulative sum is already present in the hashmap, it means that there is a subarray with equal number of 0s and 1s. We will calculate the length of this subarray and update the result if it is greater than the current result. If the cumulative sum is not present in the hashmap, we will add it to the hashmap with its index.

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int rSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                rSum = rSum + 1;
            } else {
                rSum = rSum - 1;
            }
            if ((!map.containsKey(rSum))) {
                map.put(rSum, i);
            } else {
                result = Math.max(result, i - map.get(rSum));

            }
           

        }
 return result;
    }
}