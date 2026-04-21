// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This code uses a running sum (decrementing for 0 and incrementing for 1) to track the balance between the two numbers, where a repeating sum indicates that the counts of 0s and 1s between those two indices are perfectly equal.
// By storing the first occurrence of each sum in a HashMap, you can calculate the distance between identical sums to find the maximum length of a balanced subarray.

import java.util.HashMap;
import java.util.Map;

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int count = 0, maximumLength = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                count = count -1;
            } else {
                count = count + 1;
            }

            if (hashMap.containsKey(count)) {
                int size = i - hashMap.get(count);
                if (size > maximumLength) {
                    maximumLength = size;
                }
            } else {
                hashMap.put(count, i);
            }

        }
        return maximumLength;
    }
}