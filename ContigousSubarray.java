/**

Time Complexity : O(N) N = input size
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        int result = 0;
        
        if(nums == null || nums.length ==0)
            return result;

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
                sum--;
            else
                sum++;


            if(map.containsKey(sum))
            {
                int firstOccurence = map.get(sum);
                result = Math.max(result, i - firstOccurence);
            }
            else
            {
                map.put(sum, i);
            }
        }

        return result;
    }
}