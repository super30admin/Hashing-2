// 560. Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/description/



/**
 * Time Complexity: O(n) since we iterate over all numbers
 * Space Complexity: O(n) because in worst case if all sums are unique
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        int rSum = 0;
        int count = 0;

        map.put(0, 1);  // edge case i.e if subarray with sum k starts from index 0

        for(int i = 0 ; i < nums.length ; i++){
            rSum = rSum + nums[i];

            if(map.containsKey(rSum - k)){    // if (currentSum - k) is already in map
                count = count + map.get(rSum - k);  // from that index to currentSum index we have sum as K hence we add count i.e how many times (currentSum - k) occurred
            }

            if(map.containsKey(rSum)){
                map.put(rSum, map.get(rSum) + 1);  // increase count by 1 if aready rSum in present
            }else{
                map.put(rSum, 1);
            }
        }

        return count;
    }
}