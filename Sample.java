//Problem 525(Contiguous Array)

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<>();
        int max=0;
        int rsum=0;
        map.put(0,-1);
        //Iterate over array
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                rsum--;
            }
            else
            {
                rsum++;
            }
            if(map.containsKey(rsum))
            {
                int x=i-map.get(rsum);
                max=Math.max(max, x);
            }
            else
            {
                map.put(rsum, i);
            }
        }
        //check if map contains
            //update max
        //put if map doesnt contain
     return max;   
    }
}
