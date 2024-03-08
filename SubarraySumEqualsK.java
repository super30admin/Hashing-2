class Solution {
    /** 
        Running Sum + HashMap to store rs and frequency.
        TC -> O(N), where N is the length of nums
        SC -> O(N), to store rs in a HashMap
    */

    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return 0;
        Map<Integer, Integer> runningSumFreq = new HashMap<>();
        int rS = 0, y=0, count = 0;
        runningSumFreq.put(0,1);
        for(int i=0; i<nums.length; i++){
            rS += nums[i];
            y = rS - k;
            if(runningSumFreq.containsKey(y))
                count += runningSumFreq.get(y);
            runningSumFreq.put(rS, runningSumFreq.getOrDefault(rS, 0)+1);
        }
        return count;
    }
}
