// Time Complexity : O(n), where n is the length of the input array
// Space Complexity : O(n), for the HashMap storing prefix sum indices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :
// The idea is to convert the problem into one involving a running sum (prefix sum).
// - Replace 0s with -1s so we can track equal number of 0s and 1s using a running sum.
// - Maintain a HashMap to store the first index where each running sum occurs.
// - If the same running sum is seen again at a later index, it means the subarray in between has equal number of 0s and 1s.
// - The length of such a subarray is (current index - first occurrence index of that sum).
// - Track the maximum such length as we iterate through the array.

import java.util.*;

public class ContigousArray 
{
    public int findMaxLength(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        int max = 0;

        map.put(0, -1); // base case: sum=0 at index -1

        for (int i = 0; i < nums.length; i++)
        {
            // Convert 0 to -1 to balance the count
            if (nums[i] == 0) runningSum--;
            else runningSum++;

            // If we've seen this sum before, subarray in between has equal 0s and 1s
            if (map.containsKey(runningSum))
            {
                max = Math.max(max, i - map.get(runningSum));
            }
            else
            {
                // Store the first occurrence of this running sum
                map.put(runningSum, i);
            }
        }

        return max;
    }
}
