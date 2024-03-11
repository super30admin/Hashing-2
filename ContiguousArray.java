class Solution {

    // TC -> O(N), where N is the length of nums
    // SC -> O(N)
    public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums == null) return -1;

        // Running Sum & maxResult
        int rS = 0, maxLen = 0;

        // Map to locate RS and it's first occurence
        Map<Integer, Integer> rsIndexMap = new HashMap<>();

        // Dummy for RS = 0
        rsIndexMap.put(0, -1);

        // Loop through nums to find the max Length
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) rS--;
            else rS++;
            if(!rsIndexMap.containsKey(rS))
                rsIndexMap.put(rS, i);
            maxLen = Math.max(maxLen, (i - rsIndexMap.get(rS)));
        }
        return maxLen;
    }
}
