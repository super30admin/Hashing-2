/** 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 */

/**
 * The longest subarray is found by maintaining a cumulative sum (runningsum) where 0 is treated as -1 and 1 is treated as +1.
 * The HashMap is used to store the first occurrence of each cumulative sum.
 * If the cumulative sum is already present in the HashMap, it means that the subarray between the first occurrence and the current index has an equal number of 0s and 1s.
 */
import java.util.HashMap;
class contiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> earlyindex=new HashMap<>();
        earlyindex.put(0,-1);
        int rsum=0;
        int maxlength=0;
        int n=nums.length;
        for(int i=0;i<=n-1;i++)
        {
            if(nums[i]==0) rsum=rsum-1;
            else rsum=rsum+1;
            if(!earlyindex.containsKey(rsum))
            {
               earlyindex.put(rsum,i);
            }
            else maxlength=Math.max(maxlength,i-earlyindex.get(rsum));
        }
        return maxlength;

        
    }
}