// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//525. Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 1) {
                rSum += 1;
            }
            else{
                rSum -= 1;
            }
            if(map.containsKey(rSum)){
                if(max < i - map.get(rSum)){
                    max = i - map.get(rSum);
                }
            }
            else{
                map.put(rSum, i);
            }
        }
        return max;
    }
}