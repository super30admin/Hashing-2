// Time Complexity : 38ms (faster than 72% submissions)
// Space Complexity : 848 Mb (less than 38% submissions)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int sum = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i] == 1 ? 1 : -1;

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int length = i - map.get(sum);
                if (length > maxLength) {
                    maxLength = length;
                }
            }

        }

        return maxLength;

    }
}