//TimeComplexity:O(n)


class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int runningSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for( int i =0; i< nums.length; i++) {
            runningSum += nums[i];
            int res = runningSum-k;
            if(map.containsKey(res)) {
                count = count+map.get(res);
            }
            if(!map.containsKey(runningSum)){
                map.put(runningSum,1);
            } else {
                map.put(runningSum, map.get(runningSum)+1);
            }
        }
  return count;
}
}
