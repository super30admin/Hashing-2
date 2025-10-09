// Time Complexity : O(n).
// Space Complexity : O(n) - worst case
// Did this code successfully run on Leetcode : Yes
// Approach : We will have a running sum at each element of the array. We maintain a HashMap and store the rSum-k i.e complement values in the HashMap. At every
// element we check if the complement is present in the hashmap and add the count of it to the counter. This counter is the number of subarrays formed that
// matches the target.

// Your code here along with comments explaining your approach


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int output = 0;
        int rSum = 0;

        for(int i=0;i<nums.length;i++) {
            rSum += nums[i]; // running sum
            int complement = rSum - k;
            if(map.containsKey(complement)){
                output += map.get(complement); //add the occurences of complement to output
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);// add the complement to HashMap

        }
        return output;
    }
}