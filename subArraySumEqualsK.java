// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class subarraysumSolution {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0,1);
        int count = 0;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }
            
            if (!map.containsKey(currSum)) {
                map.put(currSum, 0);
            }
            
            map.put(currSum, map.get(currSum) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,7,-3,1,2,2,5,1};
        int k = 7;
        int result;
        result = subarraySum(nums, k);
        System.out.println(result);
    }
}
