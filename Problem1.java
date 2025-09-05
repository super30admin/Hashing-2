// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

// TimeComplexity: O(n)
// Space Complexity:  O(n) due to hashmap

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        int rSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            // Calculate running Sum
            rSum = rSum + nums[i];
            // Int comparivite rSum - k
            int comp = rSum - k;

            // If map contains compliment then increment count
            if(map.containsKey(comp)) {
                count = count + map.get(comp);
            }
            // append Running Sum and Count to Map
            map.put(rSum, map.getOrDefault(rSum, 0)+1);
        }
        //return count
        return count;
    }
}