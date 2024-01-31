// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Approach: Running sum pattern is used to identify the length of the subarrays.
//If '0' -> Decrement running sum by 1 else '1' -> Increment running sum by 1.
//Hashmap is used to store the running sum and the index of its first occurance.
//While iterating through the array, if the running sum for the current index exists
//in the hashmap, then we can calculate the length of the balanced subarray by taking
//the difference between the current index and the first index at which the running sum
//occurred and get the maxlength.

public class Solution {
    public int FindMaxLength(int[] nums) {
        int rSum = 0;
        int maxLength = 0;
        Dictionary<int, int> hashMap = new Dictionary<int, int>();
        hashMap.Add(0, -1); //Dummy Value

        for(int i = 0; i < nums.Length; i++) {
            if(nums[i] == 0) {
                rSum = rSum - 1;
            }
            else {
                rSum = rSum + 1;
            }
            if(hashMap.TryGetValue(rSum, out var y)) {
                int arrLength = i - y;
                if (arrLength > maxLength) {
                    maxLength = arrLength;
                }
            }
            else {
                hashMap.Add(rSum, i);
            }
        }
        return maxLength;
    }
}
