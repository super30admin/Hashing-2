/*
 * Time Complexity (TC):
O(n), where n is the length of the input array nums. The algorithm iterates through the array once, performing constant-time operations (hashmap lookups and insertions) at each step.
Space Complexity (SC):
O(n), where n is the number of distinct prefix sums in the array. In the worst case, the hashmap may store one entry for each element of the array.
Explanation of the code:
Initialization:

rSum = 0 to keep track of the running sum of the array elements.
result = 0 to store the number of subarrays whose sum equals k.
map = new HashMap<>() to store the count of each running sum encountered so far. Initially, map.put(0, 1) is added to handle the case where a subarray from the beginning sums to k.
Iterating through the array:

For each element nums[i] in the array:
The running sum rSum is updated: rSum += nums[i].
To find subarrays that sum to k, check if rSum - k exists in the map. If it does, it means there is a subarray whose sum equals k, and the count of such subarrays is added to result.
The current running sum rSum is added to the map. If it already exists, increment its count. Otherwise, initialize it with a count of 1.
Return the result: After the loop finishes, return the value of result, which holds the number of subarrays whose sum equals k.
 */


 class Solution {
    public int subarraySum(int[] nums, int k) {
    
    int n = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int rSum = 0;
    int result = 0;
    for (int i = 0; i < n; i ++) {
        rSum += nums[i];
        if (map.containsKey(rSum - k)) {
            result += map.get(rSum - k);
        }
        if (!map.containsKey(rSum)) {
            map.put(rSum, 1);
        } else {
            map.put(rSum, map.get(rSum) + 1);
        }
    }
    return result;

    }
}