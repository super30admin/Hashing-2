
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * Approach
 * we are using the running sum approach basically we as calculating the sum of all the previous nums and with it to find the longest subarray, we use hashmap to keep track of sum and index
 * for getting the sum we increase the sum by 1 when every we see a 1 and reduce it by 1 whenever we hit 0 and after each itteration we check
 * if the sum is the hashmap we check if length using that or else we add it to subarray
 * 
 */
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rsum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                rsum++;
            } else {
                rsum--;
            }
            if (map.containsKey(rsum)) {
                int len = map.get(rsum);
                maxLen = Math.max(maxLen, (i - len));
            } else {
                map.put(rsum, i);
            }
        }
        return maxLen;

    }
}