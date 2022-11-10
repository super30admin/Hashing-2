// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        int rem=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            //maintain a running sum
            sum+=nums[i];
            rem=sum-k;
              //if the running sum - k is present in the hashmap means that the the subarray from that 
              //point to current num will be equak to k hence we inc the cnt
            if(map.containsKey(rem)){
                cnt+=map.get(rem);    
            }
            //if map coantains subarray key then increament the cnt which is stored as value else put the key with default value 1
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        
        return cnt;
    }
}