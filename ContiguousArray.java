// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We use the running sum method. If a 0 is encountered, we subtract 1 and if a 1 is encountered, we add 1
// 2: We create a HashMap that stores the running sum as the key and the index at which we have first reached this running sum value
// 3: When we next encounter the same running sum, we know the array is balanced and can calculate the max contiguous length
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int rSum = 0;
        map.put(0, -1);
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                rSum -= 1;
            }
            else if(nums[i] == 1){
                rSum += 1;
            }
            if(!map.containsKey(rSum)){
                map.put(rSum, i);
            }
            else{
                maxLength = Math.max(maxLength, i-map.get(rSum));
            }
        }
        return maxLength;
    }
}