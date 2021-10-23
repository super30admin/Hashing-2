// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class findmaxlengthSolution {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        int maxLength = 0;
        int currSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 0) {
                currSum += -1;
            }
            else {
                currSum += 1;
            }
            
            if (map.containsKey(currSum - 0)) {
                maxLength = Math.max(maxLength, i - map.get(currSum));
            }
            else {
                map.put(currSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,1,0,1,0,0};
        int result;
        result = findMaxLength(nums);
        System.out.println(result);
    }
}
