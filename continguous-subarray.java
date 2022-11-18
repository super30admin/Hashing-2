import java.util.*;

//time complexity is O(n) and space complexity is O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int rsum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max_length = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                rsum = rsum - 1;
            } else {
                rsum = rsum + 1;
            }

            if (map.containsKey(rsum)) {
                max_length = Math.max(max_length, i - map.get(rsum));
            } else {
                map.put(rsum, i);
            }
        }

        return max_length;

    }
}