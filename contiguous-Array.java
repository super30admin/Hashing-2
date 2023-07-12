// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int rsum = 0;
        int curr = 0;
        int max =0;
        map.put(0,-1);
        for(int i =0; i<n; i++){
            curr+= 1;
            if(nums[i]==1){
                rsum+= 1;
            }
            else{
                rsum+= -1;
            }
            // if(rsum-){
            //     max= Math.max(max, curr);
            //     curr=0;
            // }
            if(map.containsKey(rsum)){
                max = Math.max(max, i - map.get(rsum));
            }
            else map.put(rsum,i);
        }
        return max;
    }
}