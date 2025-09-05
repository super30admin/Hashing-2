
// ## Problem2 (https://leetcode.com/problems/contiguous-array/)

// TimeComplexity : O(n)

// Space Complexity : O(n)

class Solution {
    public int findMaxLength(int[] nums) {
        // HashMap to store running sum and index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Max value to retun the result
        int max = 0;
        // Insert a dummy value to Map , to have -1 index scenario
        map.put(0,-1);
        int rSum = 0;
        // Iterate through array
        for(int i = 0; i < nums.length; i++) {
            // If Nums[i] == 0 then rSum is -1
            if(nums[i] == 0) { 
                rSum--; 
            }
            // Else running Sum +1
            else { 
                rSum++;
            }
            // Id map already contains a Running Sum, We need to. check the max value
            if(map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            }
            else {
                // Else  add the running sum and index
                map.put(rSum, i);
            }
        } 
        return max;
        
    }
}