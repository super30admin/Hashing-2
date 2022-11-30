// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int FindMaxLength(int[] nums) {
        int result = 0;
        
        if(nums == null || nums.Length == 0)
            return result;
        
        Dictionary<int, int> myDict = new Dictionary<int, int>();
        myDict.Add(0,-1);
        int sum =0;
        for(int i= 0; i< nums.Length; i++)
        {
            if(nums[i] == 0)
                sum--;
            else
                sum++;
            if(!myDict.ContainsKey(sum))
                myDict.Add(sum, i);
            else
                result = Math.Max(result, i - myDict[sum]);
        }
        return result;
    }
}
