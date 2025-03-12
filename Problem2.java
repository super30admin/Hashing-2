/*
 *Time Complexity (TC):
O(n), where n is the length of the input array nums. The algorithm iterates through the array once, performing constant-time operations (hashmap lookups and insertions) at each step.

Space Complexity (SC):
O(n), as the hashmap stores the cumulative sums, which can potentially store a key for each index in the worst case.

Explanation of the code:
The code initializes a variable rSum to store the running sum and ans to track the maximum length of the subarray with an equal number of 0's and 1's.
It uses a hashmap map to store the index at which each running sum occurs. The key is the running sum, and the value is the index of that sum.
For each element in the array:
If the element is 0, it decreases the running sum (rSum--).
If the element is 1, it increases the running sum (rSum++).
If the running sum rSum has been seen before at index j, the subarray between j and the current index i has an equal number of 0s and 1s. The length of this subarray is i - map.get(rSum). The code updates the maximum length (ans) accordingly.
If the running sum has not been seen before, it adds rSum to the hashmap with the current index.
 */


 class Solution {
    public int findMaxLength(int[] nums) {
    
    int rSum = 0;
    int n = nums.length;
    int ans = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);     //dummy to catch the sub arr starting at index 0

    for (int i = 0; i < n; i ++) {
        if (nums[i] == 0) {
            rSum --;
        } else {
            rSum ++;
        }
        if (map.containsKey(rSum)) {
            ans = Math.max(ans, i - map.get(rSum));
        } else {
            map.put(rSum, i);
        }
    }
    return ans;
    }
}