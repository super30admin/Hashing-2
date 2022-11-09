//TC = SC : O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int count =0;
        int rSum = 0;
        map.put(0,1);
        for(int i = 0; i<len; i++){
            rSum += nums[i];
            if(map.containsKey(rSum - k)){
                count += map.get(rSum - k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0)+1);
        }
        return count;
    }
}
