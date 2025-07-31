// This algorithm uses prefix based solution where it tracks of the sum and also a map which tracks number of indexes with that sum. At each index we check if there was a left over number faced before to reach the sum to k. Based on number of available elements it wil increment the final count or result
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int runningSum = 0, count = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++) {
            runningSum+=nums[i];
            if(map.containsKey(runningSum-k)) {
                count+=map.get(runningSum-k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        }
        return count;
    }
}
