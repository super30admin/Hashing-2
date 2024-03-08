// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initialize a HashMap to store the cumulative sum (rSum) as keys and their corresponding indices as values.
// 2. Add an initial entry to the HashMap with key=0 and value=-1 (to handle the case where the sum of elements from index 0 to i equals 0).
// 3. Initialize variables max (to store the maximum length of the contiguous array) and rSum (to store the running sum).
// 4. Iterate through the array and update rSum based on the value of the current element (decrement if it's 0, increment if it's 1).
// 5. Check if the current rSum exists in the HashMap. If it does, update max by comparing it with (i - map.get(rSum)).
// 6. If rSum is not present in the HashMap, add it along with its index.
// 7. Repeat steps 4-6 for all elements in the array.
// 8. Return the final value of max, which represents the maximum length of a contiguous subarray with equal number of 0s and 1s.

import java.util.HashMap;

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max=0;
        int rSum=0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 0)
            {
                rSum--;
            }
            else
            {
                rSum++;
            }
            if(map.containsKey(rSum))
            {
                max = Math.max(max , i-map.get(rSum));
            }
            else
            {
                map.put(rSum, i);
            }
        }
        return max;
    }
}