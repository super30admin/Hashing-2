// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMaxLength(int[] nums) {
        Integer length = 0;
        int index = 0;
        int runningSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);

        for (int n : nums) {
            if (n == 1) {
                runningSum += 1;
            } else if (n == 0) {
                runningSum -= 1;
            }
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, index);
            } else {
                if (index - map.get(runningSum) > length) {
                    length = index - map.get(runningSum);
                }
            }
            index++;
        }
        
        return length;
    }
}
