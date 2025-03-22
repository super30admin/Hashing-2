// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Create a HashMap to store running sums and their counts.
//           Initialize map with 0 -> 1, meaning we’ve seen one subarray sum of 0 so far (an empty prefix).
//           For each element, update running sum rSum. The complement is rSum - k.
//           If we’ve seen complement before, it indicates a subarray summing to k. Add its count to the result.
//           Then store or increment rSum in the map.

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCntMap = new HashMap<>();
        int rSum = 0;
        int result = 0;
        sumCntMap.put(0, 1);
        for(int num: nums) {
            rSum += num;
            int complement = rSum - k;
            if(sumCntMap.containsKey(complement)) {
                result += sumCntMap.get(complement);
            }
            sumCntMap.put(rSum, sumCntMap.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Subarray count for [1, 1, 1] with k=2: " + solver.subarraySum(nums1, k1));

        int[] nums3 = {2, 2, -1, 1, 3, 2};
        int k3 = 4;
        System.out.println("Subarray count for [2, 2, -1, 1, 3, 2] with k=4: " + solver.subarraySum(nums3, k3));
    }
}
