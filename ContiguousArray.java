// Time Complexity : O(N) as The entire array is traversed once.
// Space Complexity : O(N) as size of the HashMap map will be N
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/contiguous-array/description/
// Any problem you faced while coding this : No, we are using running sum pattern to solve this problem.


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // put reference in the starting of 0 & -1
        int max = 0; // final-ans
        int rSum = 0; // current
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum--;
            }else{
                rSum++;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max,i-map.get(rSum));
            }else{
                map.put(rSum,i);
            }
        }
        return max;
    }
}
