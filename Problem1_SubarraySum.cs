// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Approach: Running sum pattern is used to identify the subarrays with sum = k.
//Hashmap is used to store the running sum as key and its value to be the number of its occurrances.
//While iterating through the array, if the difference between running sum for the current index and 'k' exists
//in the hashmap, then add the value hashmap to the counter. If the running exists in the hashmap, increment its value by 1.
//If not, add the rsum to hashmap with its value as 1 and return the counter.

public class Solution {
    public int SubarraySum(int[] nums, int k) {
        int rSum = 0;
        int count = 0;
        Dictionary<int, int> hashMap = new Dictionary<int, int>();
        hashMap.Add(0,1);//Dummy value
        for(int i = 0; i< nums.Length; i++) {
            rSum += nums[i];
            int y = rSum - k;
            if(hashMap.ContainsKey(y)) {
                count = count + hashMap[y];
            }
            if(hashMap.TryGetValue(rSum, out var val)) {
                hashMap[rSum] = ++val;
            }
            else {
                hashMap.Add(rSum, 1);
            }
        }
        return count;
    }
}
