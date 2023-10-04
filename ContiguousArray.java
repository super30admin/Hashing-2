// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int findMaxLength(int[] nums) {

           HashMap<Integer,Integer> map = new HashMap<>(); 
           int rSum = 0;
           map.put(0,-1);
           int l =0;
           
           for(int i =0; i < nums.length; i++)
           {
               if(nums[i] ==0)
               rSum -= 1;
               else 
               rSum += 1;

                if(map.containsKey(rSum))
                l = Math.max(l ,i - map.get(rSum));
                else 
                 map.put(rSum,i);
    
           }
           return l;

    }
}
