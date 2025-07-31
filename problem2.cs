public class Solution {
    public int FindMaxLength(int[] nums) {
        var runningSumMap = new Dictionary<int,int>();
        runningSumMap.Add(0,-1);
        var result=0;
        var runningSum=0;
        for(var i=0;i<nums.Length;i++)
        {
            if(nums[i]== 0)
            {
                runningSum = runningSum-1;
            }
            else
            {
                runningSum = runningSum+1;
            }
            if(runningSumMap.ContainsKey(runningSum))
            {
                var index = runningSumMap[runningSum];
                result = Math.Max(result,i-index);

            }
            else
            {
                runningSumMap.Add(runningSum,i);
            }

        }
        return result;
    }
}