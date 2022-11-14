import java.util.HashMap;

/**
 * LeetCode525
 */
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        hmap.put(0, -1);// this is to handle special case where we have [0,1] in this case our approach
                        // will not give correct answer.
        int rsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rsum = rsum - 1;
            } else {
                rsum = rsum + 1;
            }
            if (!hmap.containsKey(rsum)) {
                hmap.put(rsum, i);
            } else {
                max = Math.max(max, i - hmap.get(rsum));
            }
        }
        return max;
    }
}

// Time complexity==O(n)
// Space Complexity==O(n)