// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<nums.length; i++) {
            sum = nums[i] == 0 ? sum-1 :sum+1;
            if(map.containsKey(sum)) {
                int curr = i - map.get(sum);
                max = Math.max(max,curr);

            } else {
                map.put(sum,i);
            }
        }
        return max;
    }
}