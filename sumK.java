// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count=0;
        int curr_sum = 0;
        HashMap<Integer,Integer> hmap = new HashMap <Integer,Integer>();
        
        for(int i=0; i<nums.length; i++){
            curr_sum += nums[i];
            if (curr_sum == k) count++;
            
            if(hmap.containsKey(curr_sum-k))
            {
                
                count += hmap.get(curr_sum-k);
            }
            if(!hmap.containsKey(curr_sum))
            {
                
                hmap.put(curr_sum,1);
            }
            else
            {
                hmap.put(curr_sum, hmap.get(curr_sum)+1);
            }
            
            
        }
        return count;
        
    }
}