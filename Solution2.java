import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* I take a map and add (0,-1) to it which denoted running sum 0 at position -1. I then iterate through the array and add 1 to the running sum for every 1 and remove 1 for every 0. If map does
* not contain running sum, I'll add the running sum along with the index at which it first occurred. If running sum is already present in the map, I calculate max length as maximum of current  
*  value of length and current index i - map.get(rSum)
*/

 class Solution2 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int rSum = 0, len = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                rSum-=1;
            }
            else
            {
                rSum+=1;
            }
            if(!map.containsKey(rSum))
            {
                map.put(rSum,i);
            }
            else
            {
                len=Math.max(len,i-map.get(rSum));
            }
        }
        return len;
    }
}