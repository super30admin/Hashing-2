// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
I would maintain a map to store the running sum of the values and respective count occurence. If at any time, the difference of the running sum and target value k which is also a sum appears in the map already, it means we have already made certain sub arrays which satisfy the condition, so we want to make sure we add those as well to our overall count. If running sum is not present in the map, then we simply add it to the map. As an edge case, we give 0 for 1 count for subarraysum scenario where we see early running sum as 0 in short array.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i = 0 ; i < nums.length ; i++) {
            rSum += nums[i];
            int cmp = rSum - k;
            if(map.containsKey(cmp)) {
                count += map.get(cmp);
            }
            map.put(rSum, map.getOrDefault(rSum , 0) + 1);
        }
        return count;
    }
}
