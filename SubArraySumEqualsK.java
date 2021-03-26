
// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int cnt = 0;
        int rSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i < nums.length ; i++){
            rSum += nums[i];
            int diff = rSum - k;
            if (map.containsKey(diff)){
                cnt += map.get(diff);
            }
            if (map.containsKey(rSum)){
                map.put(rSum,map.get(rSum)+1);
            }else{
                map.put(rSum,1);
            }
        }
        return cnt;
    }
}