// Time Complexity : O(n) where n is the length of the array nums
// Space Complexity : O(n) as we need to create a hashMap for prefixSum of n elements
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


import java.util.HashMap;
class ContiguousArray {
    public int findMaxLength(int[] nums)
    {
        if(nums == null || nums.length <1){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        //base case
        map.put(0, -1);

        int sum = 0;
        int max = 0;

        for(int i =0; i< nums.length; i++){
            if(nums[i] == 0){
                sum--;
            }else{
                sum++;
            }
            if(map.containsKey(sum)){
                max = Math.max(max, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }
}