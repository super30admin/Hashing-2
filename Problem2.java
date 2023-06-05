// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the length of the given array

// Your code here along with comments explaining your approach
    //While traversing through the array, we keep track of a counter "which gives the number of ones - number of zeros", we also maintain a map (key, value) to store the earliest occurrence of the counter at each iteration.
    //At every iteration, we look for the earliest occurrence of current value of the counter in the map. The intervals between same value of the counter are balanced(same number of ones and zeros).
    //We only consider the max distance between a value of the counter and its earliest occurrence.

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int oneZeroCounter = 0;
        map.put(0, -1);
        int n = nums.length;
        int maxLen = 0;
        for (int i=0; i<n; i++)
        {
            int x = nums[i];
            if (x==1)
            {
                oneZeroCounter++;
            }
            else
            {
                oneZeroCounter--;
            }
            maxLen = Math.max(maxLen, i-map.getOrDefault(oneZeroCounter, i));
            map.putIfAbsent(oneZeroCounter, i);
        }
        return maxLen;
    }
}