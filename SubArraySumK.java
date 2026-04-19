// Time Complexity :O(N) - we traverse the array once, where N is the length of the array.
// Space Complexity :O(N) - in the worst case, we might store all prefix sums in the hashmap if all elements are unique and do not sum up to k.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes bit confused about the idea 
// of prefix sum and how to use it to find the count of subarrays that sum up to k.


// Your code here along with comments explaining your approach
// Followed the prefix sum approach to solve this problem. 
// We maintain a running sum (rSum) as we iterate through the array.
// We also maintain a hashmap to store the frequency of each prefix sum we encounter.
// For each element in the array, we update our running sum and check if there is a prefix sum that, when subtracted from the current running sum, equals k. 
// If such a prefix sum exists in the hashmap, it means that there is a subarray that sums up to k, 
// and we add the frequency of that prefix sum to our result. 
// Finally, we update the frequency of the current running sum in the hashmap and continue iterating through the array until we have processed all elements.
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // important edge case
        
        int rSum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            
            int compt = rSum - k;

            if (map.containsKey(compt)) {
                result += map.get(compt);
            }

            // always update prefix sum frequency
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }
}