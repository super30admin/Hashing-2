// CONTIGUOUS ARRAY

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) //Return if the array itself is not initialized or if it does not have any elements
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>(); //Hashmap to store the running sums and their corresponding indices
        map.put(0, -1); //Put dummy key value pair into the hashmap to cover edge case (Say, the array is [1, 0] which is a balanced pair!)
        int rSum = 0; //Variable to incrementally calculate the running sum
        int maxLength = 0; //Initially there is no balanced subarray

        for(int i = 0; i < nums.length; i++){ //Loop through all the elements in the array
            //Decrementing the running sum when 0 is encountered and incrementing it when 1 is encountered will help in figuring if the subarray is balanced or not, if the running sums are same between 2 indices, then the subarray is balanced. We only have to store the first occurrences and corresponding indices because we are finding the longest subarray
            if(nums[i] == 0)
                rSum--;
            else
                rSum++;
            if(map.containsKey(rSum)){ //If hashmap contains the rSum, update maxLength to hold the length of the longest subarray
                maxLength = Math.max(maxLength, (i - map.get(rSum)));
            } else {
                map.put(rSum, i); //If hashmap does not have the rSum value, put it in
            }
        }
        return maxLength; //Return length of the longest balanced subarray
    }
}