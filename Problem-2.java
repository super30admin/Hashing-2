// Time Complexity =O(n)
// Space Complexity - O(1)
// solved in leetcode - Yes
// faced any issues - No
// Calculating the running Sum, for each element and check if the runningsum available in map,
// If not available adding it, else chceking the difference and updating max by maximum.
class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0, rSum=0;
        HashMap<Integer, Integer> s = new HashMap<>();
        s.put(0,-1);
        for(int i=0;i<nums.length;i++) {
            rSum = nums[i] == 0 ? (rSum-1) : (rSum+1);
            if(!s.containsKey(rSum)) {
                s.put(rSum, i);
            } else {
                max = Math.max(max, i- s.get(rSum));
            }
        }
        return max;
    }
}
