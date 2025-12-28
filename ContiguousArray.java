// Time Complexity : O(N), Go through all the elements to find the max length
// Space Complexity : O(N), keep the sums for all the N values in the map in the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach :
// We will perform a zero-sum Search. By treating 0 as -1, any subarray where the 1s and -1s cancel each other out
// (summing to 0) must have an equal count of both.

//We are going to store Prefix Sum with a Hashmap to find these "balanced" sections. It tracks the running total as
// it loops through the array; if it hits a sum it has seen before, it knows the elements between those two points
// perfectly balanced out, and it calculates that distance to find the maximum length.
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        // Keep the sum seen previously and the corresponding index, index will be help to find the max length
        Map<Integer, Integer> previousSumIndexMap = new HashMap<>();

        // Put the initial sum of 0 and index as -1, will be useful for calculating length at index 0
        previousSumIndexMap.put(0, -1);

        int currentSum = 0;
        int maxLength = 0;
        for(int index= 0; index < len; index++){
            // Change 0 to -1, so that 1 and -1 balances each other out and total sum becomes 0
            if(nums[index] == 0) {
                nums[index] = -1;
            }

            currentSum += nums[index];
            // check if the current sum as already appeared before, it indicates we found subarray with longer length
            // calculate the new max length
            if(previousSumIndexMap.containsKey(currentSum)){
                int previousIndex = previousSumIndexMap.get(currentSum);
                maxLength = Math.max(maxLength,  index - previousIndex);
            }else{
                previousSumIndexMap.put(currentSum, index);
            }
        }

        return maxLength;
    }
}
