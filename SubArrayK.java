// Time complexity -- O(n)
// Space complexity  -- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int runningSum = 0;
        for (int i= 0; i < nums.length; i++){
            runningSum += nums[i];
            int compliment = runningSum - k;
            if(map.containsKey(compliment)){
                count += map.get(compliment);
            }
            if(map.containsKey(runningSum)){
                map.put(runningSum , map.get(runningSum) +1);
            } else{
                map.put(runningSum,1);
            }
        }
        return count;
    }
}