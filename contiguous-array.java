// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {
        // base case
        if (nums.length == 0 || nums == null)
            return 0;
        // logic
        if (nums[0] == 0)
            nums[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
            nums[i] = nums[i] + nums[i - 1];
        }
        HashMap<Integer, Integer> exist = new HashMap<>();
        exist.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // int n ;
            if (!exist.containsKey(nums[i]))
                exist.put(nums[i], i);
            max = Math.max(max, i - exist.get(nums[i]));
        }
        return max;
    }
}