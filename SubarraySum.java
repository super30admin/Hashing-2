/**

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Input: nums = [1,1,1], k = 2
Output: 2

0,1,2
1,2,3

1 -> 0
2 -> 1
3 -> 2

sum = +nums[i];
int difference = sum - k;


Time Complexity : O(N) N = input size
Space Complexity : O(N) N = input size
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int result = 0;
        
        if(nums == null || nums.length ==0)
           return result;
           
        int sum = 0;
        
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
           
        for(int i=0; i< nums.length; i++)
        {
            sum = sum + nums[i];
            int diff = sum -k;
            
            
            if(map.containsKey(diff))
            {
                int prevCount = map.get(diff);
                result = result + prevCount;
            }
            
            map.putIfAbsent(sum, 0);
            map.put(sum, map.get(sum) + 1);
        }
        
        return result;
    }
}