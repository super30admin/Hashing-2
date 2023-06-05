// Time Complexity : O(n) where n is the length of the nums array
// Space Complexity : O(n) as we need to create a hashMap of the prefixSum for n elements
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.HashMap;

class SubArraySumK {
    public int subarraySum(int[] nums, int k) {

        if(nums == null || nums.length < 1){
            return 0;
        }
        if(nums.length == 0){
            if(nums[0] == k) return 1;
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        Integer sum = 0;
        int count = 0;
        for(int i =0; i< nums.length ; i++){
            sum = sum + nums[i];
            Integer diff = Integer.valueOf(sum - k);
            if(map.containsKey(diff)){
                count = count + map.get(diff);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) +1);
            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumK obj = new SubArraySumK();
        int[] nums = {1,-1,0};
        int k = 0;

        System.out.println(obj.subarraySum(nums, k));
    }
}