// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Running Sum, increment total whensame difference is found
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rs = 0;
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            
            rs = rs + nums[i];
            int check = rs-k;
            if(map.containsKey(check)){
                count = count + map.get(check);
                    
            }
            map.put(rs, map.getOrDefault(rs,0)+1);
                
            
        
        }
        return count;
        
    }
}