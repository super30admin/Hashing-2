public class Solution
    {
        // Time Complexity : O(n) -- since we are going over the entire array
        // Space Complexity : O(n) 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int SubarraySum(int[] nums, int k)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            map.Add(0, 1);
            int totalCount = 0;
            int runningSum = 0;

            for (int i = 0; i < nums.Length; i++)
            {
                //calculate the running sum
                runningSum = runningSum + nums[i];

                //calculate y = x - z(target k)
                int complement = runningSum - k;

                //check if hashmap contains y, if yes then add number of times the y has happened to the count 
                if (map.ContainsKey(complement))
                {
                    totalCount = totalCount + map[complement];
                }

                //if hashmap does not contain the runningSum then add it with 1 as the count, else update the number of times by 1
                if (!map.ContainsKey(runningSum))
                {
                    map.Add(runningSum, 1);
                }
                else
                {
                    map[runningSum] = map[runningSum] + 1;
                }
            }
            return totalCount;
        }
    }
