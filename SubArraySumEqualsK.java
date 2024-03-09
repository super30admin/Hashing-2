// Time Complexity : O(n) where 'n' is the length of the array.
// Space Complexity : O(n) where 'n' is the space used in hashmap
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/subarray-sum-equals-k/
// Any problem you faced while coding this : We use running sum method to solve this problem where in hashmpa we are storing the runningSum and frequency.
// We are subtracting runningSum from k and checking if difference exist in hashMap or not. If yes, we are increasing the count by the frequency of runningSum.


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int rSum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            rSum +=nums[i];
            int y = rSum-k;
            if(map.containsKey(y)){
                count+=map.get(y);
            }
            if(!map.containsKey(rSum)){
                map.put(rSum,1);
            }else{
                map.put(rSum,map.get(rSum)+1);
            }
        }
        return count;
    }
}
