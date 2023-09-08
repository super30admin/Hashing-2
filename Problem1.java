// Time Complexity : O(n) we loop through all indices in nums
// Space Complexity : O(n) we store upto n values in map in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int subarraySum(int[] nums, int k) {

        if(nums.length == 0 || nums == null) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];

            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
