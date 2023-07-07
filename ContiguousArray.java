// Time complexity -- O(n)
// Space complexity  -- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0 , max = 0;
        map.put (0, -1);
        if (nums == null || nums.length == 0)
            return 0;
        for  (int i = 0 ; i< nums.length ; i++){
            if(nums[i] == 0){
                runningSum--;
            }else {
                runningSum++;
            }
            if (map.containsKey (runningSum)){
                max= Math.max(max, i - map.get(runningSum));
            } else {
                map.put(runningSum, i );
            }
        }
        return max;
    }
}