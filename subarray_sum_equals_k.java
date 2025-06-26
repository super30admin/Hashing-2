// This solution solves the problem by calculating running sum
// Time complexity - O(n) <-- we only iterate over each elemnt once, linearly
// Space Complexity - O(n) <-- we store the values in a hashmap which in worse case is n 

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1 && nums[0] == k){
            return 1;
        }

        int rSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            // Calculate running sum
            rSum = rSum + nums[i];
            // If map contains the value such that current sum - k exists, 
            // we conclude that sub array is found and increase count
            if(map.containsKey(rSum - k)){
                count = count + map.get(rSum - k);
            }
            // We update the current sum's count
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
            
        }
        return count;
    }
}
