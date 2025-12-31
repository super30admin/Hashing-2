/*
Problem - Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
Approach - Update current_sum by adding the current value of the array to it
If curr_sum - k exists in the hash map, add its frequency (map[curr_sum - k]) to count
Add (curr_sum, freq) to the hash map. If the key is already present, increase its frequency; if not, set it to 1.
Time Complexity - O(n) - iterating over all the elements of an array
Space Complexity - O(n)
 */

import java.util.HashMap;

public class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            // updating the running prefix sum by adding the current number
            currentSum += num;
            // if currentSum-k is present the map add its frequency value to the counter
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            // store the currentSum value in the hash map, if the current sum is already present in the map increase it by 1
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
