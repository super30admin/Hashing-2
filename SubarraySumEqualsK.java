// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int running_sum = 0;

        for(int i=0; i< nums.length; i++){
            running_sum += nums[i];
            if(map.containsKey(running_sum - k)) count += map.get(running_sum - k);
            map.put(running_sum, map.getOrDefault(running_sum, 0) + 1);
        }
        return count;
        
    }
}