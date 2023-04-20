## Problem2 (https://leetcode.com/problems/contiguous-array/)

// Time Complexity - O(n) because it involves a single pass over the input array of size n.
// Space Complexity - O(n)  because it uses a HashMap to store the running sum as the key and the index as the value.


class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {           // base case given empty array
            return 0;
        }
        int max = 0;                                      // contains the maximum length of contiguous sub array which has equal 0's $ 1's 
        int rSum = 0;                                     // running sum 
        HashMap<Integer, Integer> map = new HashMap<>();  // using a hasmap with integer as the element
        map.put(0, -1);                                   // base case

        for (int i = 0; i < nums.length; i++) {           // iterating through nums.length
            if (nums[i] == 0) {                           // if nums of i is zero substract 1 from rSum (logic)
                rSum = rSum - 1;
            }
            else {
                rSum = rSum + 1;                          // otherwise add 1 to running sum (rSum)
            } 
            if (map.containsKey(rSum)) {                  // check if the map conatins the rSum 
                max = Math.max(max, i - map.get(rSum));   // update the max value
            }
            else {
                map.put(rSum, i);                         // adding key i.e rSum and i which is index to map
            }
        }
        return max;
    } 
}

## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

// Time Complexity - O(n) because it involves a single pass over the input array of size n and in each iteration of the for loop, constant time operations are performed, such as updating the running sum, checking the presence of a key in the HashMap, and updating the HashMap.
// Space Complexity - O(n) because it uses a HashMap to store the running sum as the key and the frequency of the sum as the value


class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {             // if nums or length of array is null or 0 return 0
            return 0;
        }
        int total = 0;                           // keep a track of the total contigous sub array which are summing upto k
        HashMap<Integer, Integer> map = new HashMap<>();          // contributes to space complexity O(n)
        int rSum = 0;                                         // running sum
        map.put(0, 1);                                        // initialize the hashmap

        for (int i = 0; i < nums.length; i++) {             // iterate for loop till nums.length also contributes to time complexity O(n)
            rSum = rSum + nums[i];                           // update the running Sum rSum
            if (map.containsKey(rSum - k)) {                // check map conatins key i.e rSum - k    // constant 
                total = total + map.get(rSum - k);          // upadte the total 
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);  //update and add rSum with getorDefault method will check map for rSum  // constant
        }
        return total;
    }
}