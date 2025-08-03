/** Time complexity: O(n)
 * Space complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 */

/**
 * The HashMap is used to store the cumulative sum of elements(runningsum).
 * If it is not already present the runningsum is added as key with value 1 else the value i.e., frequency of runningsum corresponding to the key is incremented by 1.
 * The complement of the runningsum is calculated by subtracting k from the runningsum and the same is searched in the HashMap. 
 * If at all complement is present, then the frequency corresponding to the complement is added to the count to obtain the number of subarrays with the given sum k. (uses approach if x+z=y then x=y-z))
 */

import java.util.HashMap;
class subArraySum {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> runningsum=new HashMap<>();
        runningsum.put(0,1);
        int rsum=0;
        int count=0;
        for(int num: nums){

            rsum=rsum+num;
            int complement=rsum-k;

            if(runningsum.containsKey(complement))
            {
                count=count+runningsum.get(complement); 
            }
            runningsum.put(rsum, runningsum.getOrDefault(rsum, 0) + 1);
            
        }

        return count;
    

        
    }
}