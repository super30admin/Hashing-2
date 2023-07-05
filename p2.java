// Time Complexity : Time complexity will be O(n) since we are traversing through array
// Space Complexity : Space complexity would be O(n) since there could be n number of elements in hashmap
// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using hashmap to store the running sum of the array. Checking everytime if the occurence of running sum has occure previously. If it has occured previously then calculating the length of the array and replacing max if max is smaller than length of the array

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int rs = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rs--;
            } else {
                rs++;
            }
            if (map.containsKey(rs)) {
                max = Math.max(i - map.get(rs), max);
            } else {
                map.put(rs, i);
            }
        }

        return max;
    }
}