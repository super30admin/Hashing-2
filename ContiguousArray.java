// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Use a runningSum where we decrement for '0' and increment for '1'.
//           Maintain a HashMap that stores the first occurrence of a given runningSum.
//           If the runningSum is seen again, we compute the subarray length from the first occurrence + 1 up to current index.


import java.util.*;
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int runningSum = 0;
        //add {0,-1} in map which means 0 running sum happens at -1 index like before starting array to handle edge case of complete nums is balanced.
        sumIndexMap.put(0, -1);

        //loop over nums to find longest balanced array i.e. equal nos. of 0 and 1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                runningSum--;
            } else {
                runningSum++;
            }
            if(sumIndexMap.containsKey(runningSum)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(runningSum));
            } else {
                sumIndexMap.put(runningSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray solver = new ContiguousArray();

        int[] nums1 = {0,1};
        System.out.println("Max length (0,1): " + solver.findMaxLength(nums1));

        int[] nums5 = {0,0,0,1,1,1,0,1};
        System.out.println("Max length (0,0,0,1,1,1,0,1): " + solver.findMaxLength(nums5));

    }
}
