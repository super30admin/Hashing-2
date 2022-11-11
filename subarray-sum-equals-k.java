// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/subarray-sum-equals-k/

//we calculated the reading sum, and then checked all the sum differences which 
// will give us the differnce k;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sum = sum + n;
            int key = sum - k;
            if (map.containsKey(key))
                count += map.get(key);
            // map.putIfAbsent(nums[i],0);
            // map.put(nums[i],map.get(nums[i])+1);
            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else
                map.put(sum, 1);
        }
        return count;
    }
}