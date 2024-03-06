// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0, rSum = 0;
        for(int i=0; i< nums.length; i++){
            rSum += nums[i];
            int y = rSum - k;
            if(map.containsKey(y)){
                count += map.get(y);
            }
            map.put(rSum, map.getOrDefault(rSum,0)+1);
            // if(!map.containsKey(rSum)){
            //     map.put(rSum,1);
            // }else{
            //     map.put(rSum, map.get(rSum)+1);
            // }
        }
        return count;
    }
}