// Time Complexity : O(n) we loop through all indices in nums
// Space Complexity : O(n) we store upto n values in map in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, coming up with calculation was a little confusing at first

public class Problem2 {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        int max = 0;
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum = rSum -1;
            }else{
                rSum = rSum +1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }else{
                map.put(rSum, i);
            }
        }
        return max;

    }
}
