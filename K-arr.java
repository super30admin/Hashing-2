// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I am using a HashMap and running sum technique for this problem. 
// I iterate through the array and calculate the running sum. Then I 
// calculate the difference of the rSum and target val. If the map 
// currently contains the difference, then add to the count.
// if the rSum val is in the map, add 1 to the val, otherwise put rSum, 1 into the map.
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0; // num of subarrays possible
        int rSum = 0; //running sum 
        map.put(0, 1); // dummy val
        for(int i = 0; i < nums.length; i++){
            rSum += nums[i];
            int complement = rSum - k;
            if(map.containsKey(complement)){
                count += map.get(complement);
            }
            if(map.containsKey(rSum)){
                map.put(rSum, map.get(rSum) + 1);
            }
            else{
                map.put(rSum, 1);
            }
        }
        return count;
    }
}