public class Solution {
    public int SubarraySum(int[] nums, int k) {
        var runningSumMap = new Dictionary<int,int>();
        runningSumMap.Add(0,1);
        var result=0;
        var runningSum=0;
        var temp=0;
        for(var i=0;i<nums.Length;i++)
        {
            runningSum = runningSum+nums[i];
            temp=runningSum-k;
            if(runningSumMap.ContainsKey(temp))
            {
                var count = runningSumMap[temp];
                result = result+count;

            }
            if(runningSumMap.ContainsKey(runningSum))
            {
                var existingCount = runningSumMap[runningSum];
                runningSumMap[runningSum]=existingCount+1;
            }
            else
            {
                runningSumMap.Add(runningSum,1);
            }
            

        }
        return result;
        
    }
}