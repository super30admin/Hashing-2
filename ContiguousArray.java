//Given a binary array nums, return the maximum length of a contiguous subarray
// with an equal number of 0 and 1.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: no
//Approach:
// 1. Maintain the running sum i.e increment by 1 if 1, decrement by 1 if 0
// 2. If running sum is 0, subarray from 0 till index i contains equal 0's and 1's
// 3. If running sum is x, then the leftmost idx where running sum is x and the subarray following it
//      has equal 0's and 1's
// 4. Use hashmap to store the running sum and the first index where is occurs
// 5. Maintain the maxLen variable to track the maximum length.


import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    private static int findMaxLength(int[] nums) {
        int maxLen = 0, sum=0;
        Map<Integer, Integer> sumIdxMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            // If running sum is 0, subarray from 0 till index i contains equal 0's and 1's
            if(sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // subarray from sumIdxMap.get(sum) till i has equal 0's and 1's
            if(sumIdxMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIdxMap.get(sum));
            } else {
                sumIdxMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,1,1,1,1,0,0,0})); //6
    }
}
