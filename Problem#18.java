// SUBARRAY SUM EQUALS K

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) //Return if the array itself is not initialized or if it does not have any elements
            return -1;

        HashMap<Integer, Integer> map = new HashMap<>(); //Hashmap to store the running sums and their frequencies because we have to return the total number of subarrays whose sum equals k
        map.put(0, 1); //Put dummy key value pair into the hashmap to cover edge case (Say, the array is [3, 4] and k = 7, 7-7=0 and we donot want to miss this initially, hence have an occurrence of 0 in the HashMap)

        int frequency = 0; //Variable to count the total subarrays whose sum equals k
        int rSum = 0; //Variable to incrementally calculate the running sum

        for(int i = 0; i < nums.length; i++){ //Loop through all the elements in the array
            rSum += nums[i]; //Calculate the running sum
            if(map.containsKey(rSum - k)){ //Sum of (difference between the running sum and the target) and the runningSum will give us the target and it is a possible subarray for the given contraints
                frequency += map.get(rSum - k); //Increment frequency the number of times the difference occurs because there will be that many subarrays summing up to the target value
            }
            if(!map.containsKey(rSum)){ //Put rSum and frequency as 1 if it is not already there in the map
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1); //Increment frequency corresponding to rSum if it is already in the map
            }
        }

        return frequency; //Total number of subarray summing up to k
    }
}
