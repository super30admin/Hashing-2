//This problem was asked at Facebook
//
//
//        LeetCode: 560
//
//        Given an array of integers and an integer k, find the total number of continuous subarrays that can be formed such that sum of the subarrays is equals to k.
//
//        Example 1:
//
//        Input:nums = [1,1,1], k = 2
//
//
//
//        Output: 2

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int counter=0;
        int cumulativeSum=0;

        for(int i=0;i<nums.length;i++){
            cumulativeSum +=nums[i];
            if(map.containsKey(cumulativeSum-k))
                counter += map.get(cumulativeSum - k);
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return counter;
    }
}