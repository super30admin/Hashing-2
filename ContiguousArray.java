/**

Leetcode 525. Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Followup: also give the starting and ending of such subarray

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Input: [0,1,0]
Output: 2

Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Collabedit: http://collabedit.com/e4gwd


input =            [ 1, 0]
runningSum =       [ 1, 0]

input =            [ 0, 1]
runningSum =       [ -1, 0]

input =            [ 0, 1, 1]
runningSum =       [-1, 0, 1]

input =            [ 1, 1, 0]
runningSum =       [ 1, 2, 1]

**/


class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        if ( nums == null || nums.length ==1) return 0;
        
        if( nums.length == 2) 
        {
            if(nums[0] != nums[1]) return 2;
            else return 0;
        }
        
        int length = nums.length;
        
        int runningSum[] = new int[length];
        
        int sum = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        
        // the initial sum of 0 is existing at index 1
        hashMap.put(sum, -1);
        
        for ( int i = 0; i < length; i++ )
        {
            if (nums[i] == 1) sum++;
            else sum--;
            
            runningSum[i] = sum;
        }
        
        
        int maxLength = 0;
        
        for( int i =0 ; i < length; i++) 
        {
            int currentSum = runningSum[i];
            
            if( hashMap.containsKey( currentSum) )
            {
                // get the index where there was same running sum
                int index = hashMap.get( currentSum);
                int currentLength = i - index;
                
                maxLength = Math.max( currentLength, maxLength);
            }
            else
            {
                hashMap.put( currentSum, i);
            }
        
        }// end of for loop
        
        
        return maxLength;
    }
}

