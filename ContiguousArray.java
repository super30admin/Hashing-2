// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
I would maintain a map to store the running sum of the values and respective index. If at any time,
sum repeats(most likely 0 as 1-1 = 0),it means equal number of 1's and 0's are present till that index. So we try to obtain the difference of those indices to get the maxLength. As an edge case, we give 0 for -1 index for maxLength scenario where we see early running sum in short array.
*/
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            sum += (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(sum))
                maxLength = Math.max(maxLength, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return maxLength;
    }
}
