// Subarray Sum Equals K

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We calculate the running sum, the see if the difference between the current running sum and k is akready present in the calculated running sums. 
//If yes then we have found the subarray.Then we increment the count by the number of times we have found that running sum.
//We will maintain a hashmap with the key as the running sum and the values as the number of occurences of that sum. 

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {


        int count=0;
        int runningSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
           // calculate the running sum
            runningSum += nums[i];

            //Calculate the difference between running sum and k
            int diff=runningSum-k;


            // check if the difference is already present in the hashmap
            if(map.containsKey(diff))
            {
                count+=map.get(diff);
            }
                 
//Increment the count of the runningSum in the map
            if(map.containsKey(runningSum))
            {
                map.put(runningSum,map.get(runningSum)+1);
            }
            else
            {
                map.put(runningSum,1);
            }

        }
return count;
    }
}
