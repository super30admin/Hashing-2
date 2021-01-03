/**
Leetcode: 560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.


Input: nums = [1,1,1], k = 2
Output: 2

Input: nums = [1,2,3], k = 3
Output: 2

Collabedit: http://collabedit.com/vd3kv

Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        if( nums == null || nums.length == 0) return 0;
        
        int arrayLength = nums.length;
        int sumArray[] = new int[arrayLength];
        
        
        int runningSum = 0;
        int count = 0;
        
        // hashmap storing the runningSum to count of running occurence
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        hashMap.put(0,1);
        
        
        
        for( int i=0 ; i < arrayLength; i++ )
        {
            runningSum = runningSum + nums[i];
            
            int complementValue = runningSum - k;
            
            if ( hashMap.containsKey(complementValue) )
            {
                int complementCount = hashMap.get( complementValue);
                count = count + complementCount;
            }
            
            if ( hashMap.containsKey(runningSum) )
            {
                int previousCount = hashMap.get(runningSum);
                hashMap.put( runningSum , previousCount + 1);
            }
            else
            {
                hashMap.put( runningSum, 1 );
            }
        
        }// end of for loop
        
        
        return count;
        
    }
}