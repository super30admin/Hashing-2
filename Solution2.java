// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums== null || nums.length == 0) return -1;
        int rSum=0;
        int max=0;
        HashMap<Integer, Integer> map = new HashMap<>(); // rSum and Starting Index of it
        map.put(0,-1); // to avoid exclusion of starting subarray
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]==1) rSum+=1;
            else rSum-=1;
            if(map.containsKey(rSum))
            {
                max= Math.max(max,i-map.get(rSum)); // find max between max and len of starting and ending index 
            }
            else
            map.put(rSum,i);
        }
        return max;
    }
}