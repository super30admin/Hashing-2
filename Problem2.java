// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Use hash map to store the running sum and index values
Increement running sum by 1 for every 1's and decreement by 1 for every 0's
Return the longest subarray in the hashmap
*/
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //dummy entry in the hashmap to evaluate the initial subarray
        int rSum = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            //increement the running sum for 1's by 1 and decreement by 1 for 0's
            if(nums[i]==0){
                rSum -= 1;
            } else {
                rSum += 1;
            }
            //check if the running sum is present in Hash map
            if (map.containsKey(rSum)) {
                int curr = i - map.get(rSum);
                max = Math.max(max, curr);
            } else {
                map.put(rSum, i);
            }
        }
        return max;  
    }
}
