// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
// To find total number of subarrays whose sum equals to k, running sum and compliment is calculated. Hash map is maintained to for running sum and no of occarances id the sum
//count is incremented if the compliment is present in hash map.

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        int rSum=0;
        for(int i=0;i<nums.length;i++){
            rSum += nums[i];
            int cmp = rSum-k;
            if(map.containsKey(cmp)){
                count += map.get(cmp);
            }
            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }
        return count;
    }
}