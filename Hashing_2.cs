using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
        }

        public int FindMaxLength(int[] nums)
        {
            //         Dictionary<int, int> dict = new Dictionary<int, int>();
            //         dict.Add(0, -1);
            //         int res = 0;
            //         int rSum = 0;
            //         for(int i = 0; i<nums.Length; i++){
            //             if(nums[i] == 1){
            //                 rSum ++;
            //             }
            //             else{
            //                 rSum --;
            //             }

            //             if(dict.ContainsKey(rSum)){
            //                 res = Math.Max(res, i-dict[rSum]);
            //             }
            //             else{
            //                 dict.Add(rSum, i);
            //             }
            //         }
            //         return res;

            // Time Complexity: O(2n+1 + n) to create and fill the arr
            // Space Complexity: O(2n+1)
            int[] arr = Enumerable.Repeat(-2, 2 * nums.Length + 1).ToArray();
            // arr.length will be the center when we have shifted the rSum by nums.length, 
            // effectively arr[nums.Length] is same as arr[0] and before that are arr[<negatives>] and after are arr[<positives>] so we set arr[0] to -1
            arr[nums.Length] = -1;
            int res = 0;
            int rSum = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                rSum += nums[i] == 1 ? 1 : -1;
                if (arr[rSum + nums.Length] >= -1)
                {
                    res = Math.Max(res, i - arr[rSum + nums.Length]);
                }
                else
                {
                    arr[rSum + nums.Length] = i;
                }
            }
            return res;
        }

        public int SubarraySum(int[] nums, int k)
        {
            // Dictionary<int, int> dict = new Dictionary<int, int>();
            // dict.Add(0,1);
            // int count = 0;
            // int rSum = 0;
            // for(int i=0; i<nums.Length; i++){
            //     rSum+=nums[i];
            //     if(dict.ContainsKey(rSum-k)){
            //         count+= dict[rSum-k];
            //     }
            //     if(!dict.ContainsKey(rSum)) dict.Add(rSum,0);
            //     dict[rSum]++;
            // }
            // return count;


            // Time Complexity: O(n^2)
            // Space Complexity: O(1)

            int count = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                int rSum = 0;
                for (int j = i; j < nums.Length; j++)
                {
                    rSum += nums[j];
                    if (rSum == k) count++;
                }
            }
            return count;
        }
        public int LongestPalindrome(string s)
        {
            // IDictionary<char, int> charToCountMatch = new Dictionary<char, int>();
            // int oddCount = 0;
            // for (int i = 0; i < s.Length; i++)
            // {
            //     if (charToCountMatch.ContainsKey(s[i]))
            //     {
            //         charToCountMatch[s[i]]++;
            //         if (charToCountMatch[s[i]] % 2 == 0) oddCount--;
            //         else oddCount++;
            //     }
            //     else
            //     {
            //         charToCountMatch.Add(s[i], 1);
            //         oddCount++;
            //     }
            // }
            // return oddCount > 1 ? s.Length - oddCount + 1 : s.Length ;


            // Time Complexity: O(n) 
            // Space Complexity: O(n)
            
            HashSet<int> set = new HashSet<int>();
            int count = 0;
            foreach (char c in s)
            {
                if (set.Contains(c))
                {
                    count += 2;
                    set.Remove(c);
                }
                else
                {
                    set.Add(c);
                }
            }
            return count < s.Length ? count + 1 : count;
        }
    }
}
