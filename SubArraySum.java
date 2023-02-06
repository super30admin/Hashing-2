/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Approach : In this we consider a hashmap and running sum. For every rsum value, we check if rsum - target exists in the map. If yes we 
 * We increment the value of count with the value of the Rsum-k element and increment the Rsum value by 1. If Rsum doesn't exists we push it in map with value 1.
 */


 //https://leetcode.com/problems/subarray-sum-equals-k/description/

class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum=0, count=0;
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            rsum=rsum+nums[i];
            if(map.containsKey(rsum-k)){
                count=count+map.get(rsum-k);
            }
            if(!map.containsKey(rsum)){
                map.put(rsum,0);
            }
            map.put(rsum,map.get(rsum)+1);
        }
        return count;
    }
}