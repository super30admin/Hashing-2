// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;

            else
                zero--;

            if (zero == 0)
                max = i + 1;

            if (!map.containsKey(zero))
                map.put(zero, i);

            else
                max = Math.max(max, i - map.get(zero));
        }
        return max;
    }
}