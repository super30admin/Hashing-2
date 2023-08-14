// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Compute the difference between runningSum 
 * and target and use that difference to lookup the hashmap
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Integer runningSum = 0;
        Integer difference = 0;
        Integer count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int num:nums){
            runningSum+=num;
            difference = runningSum - k;
            if(map.containsKey(difference)){
                count+=map.get(difference);
            }
            if(!map.containsKey(runningSum)){
                map.put(runningSum,1);
            }else{
                map.put(runningSum,map.get(runningSum)+1);
            }
        }

        return count;
    }
}
