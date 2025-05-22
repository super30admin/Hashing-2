// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


class Problem1 {
    public int subarraySum(int[] nums, int k) {
        int total = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            total += num;

            if (map.containsKey(total - k))
                count += map.get((total - k));
            
            map.put(total, map.getOrDefault(total, 0) + 1);
            
        }

        return count;
    }
}