// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int SubarraySum(int[] nums, int k) {
        int result = 0;
        
        if(nums == null || nums.Length == 0)
            return result;
        
        Dictionary<int, int> myDict = new Dictionary<int, int>();
        myDict.Add(0,1);
        int sum = 0;
        
        for(int i =0; i< nums.Length; i++)
        {
            sum += nums[i];
            if(myDict.ContainsKey(sum - k))
            {                
                result += myDict[sum-k];
            }
            
            if(myDict.ContainsKey(sum))
            {
                int val = myDict[sum];
                myDict[sum] = val + 1;                
            }                
            else
                myDict.Add(sum, 1);
        }       
        return result;
    }
}
