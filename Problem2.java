// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Problem2 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int zeros = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            else zeros--;

            if (zeros == 0) max = (i + 1);

            if (!map.containsKey(zeros)) 
                map.put(zeros, i);
            else 
                max = Math.max(max, i - map.get(zeros));

        }
        return max;
    }
}