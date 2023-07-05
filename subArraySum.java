// Time Complexity : O(n), where n is the length of the array.
// Space Complexity : O(n), since the HashMap will have at most n elements.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Create a HashMap to store the running sum and the number of times it has occured.
 * 2. Iterate through the array and calculate the running sum.
 * 3. Check if the running sum - target is present in the HashMap.
 * 4. If it is present, update the count.
 * 5. If it is not present, add the running sum to the HashMap.
 * 6. Return the count.
 */

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<len; i++){
            sum += nums[i];
            int comp = sum - k;
            if(map.containsKey(comp)){
                count += map.get(comp);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            }else{
                map.put(sum, 1);
            }
        }

        return count;
    }
}