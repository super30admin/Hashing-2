// Time Complexity : O(n)
// Space Complexity : O(n)
//https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int rSum=0;
        int result=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            rSum+=nums[i];
            if(map.containsKey(rSum-k)){
                result+=map.get(rSum-k);
            }
            if(map.containsKey(rSum)){
                map.put(rSum,map.get(rSum)+1);
            }else {
            	map.put(rSum, 1);
            }
        }
        return result;
    }
}
