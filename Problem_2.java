// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a hashmap to reduce our complexity of nested loops O(n^2) to O(n). We keep track of a running sum which is incremented by 1 when we see
   a 0 and decremented by 1 when we see a 0. Whenever we see running sum repeating that means the sum of elements between the 2 running sums is 0.
   So we subtract the array till first running sum and get the length of array whose sum is 0.
*/

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, Integer> hMap = new HashMap<>();

        hMap.put(0, -1);
        int rSum = 0, max = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == 0)
                rSum -= 1;
            else 
                rSum += 1;

            if(hMap.containsKey(rSum)) {
                max = Math.max(max, i - hMap.get(rSum));
            } else {
                hMap.put(rSum, i);
            }
        }
        return max;
    }
}