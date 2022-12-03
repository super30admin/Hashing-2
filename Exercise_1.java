// Subarray Sum Equals K
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
// Calculate the running sum for each index.
// Consider a Hashmap, in which key is the running sum and value is num of times it has occured.
// Check the Runningsum - K has happened before or not. Accordingly increase the result.


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // so that will not miss the first/base case
        int runsum = 0;
        int result = 0;

        for(int i=0; i<nums.length; i++) {
            runsum += nums[i];
            if(map.containsKey(runsum - k)) {
                //Runningsum - Target has happened before, increase result by that many
                result = result + map.get(runsum - k);
            }
            //if the Runningsum is happening for the 1st time
            if(!map.containsKey(runsum)) {
                map.put(runsum, 1);
            }
            else {
                //if the Runningsum is already present, update the occurance
                int count = map.get(runsum);
                count++;
                map.put(runsum, count);
            }
        }
        return result;
    }
}