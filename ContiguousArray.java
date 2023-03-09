/*
Time Complexity - O(N) where N is the size of input array nums.
Space Complexity - O(N) 
*/
class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        map.put(0,-1);
        
        int maxLen = 0, count = 0;

        for(int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;
            if(!map.containsKey(count)) {
                map.put(count, i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(count));
            }
        }
        return maxLen;
    }
}
