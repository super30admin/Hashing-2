import java.util.*;

public class ContinguousArray {
    // TC: O(N) where N is the size of nums array
    // SC: O(N) where N is the size of nums array
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> firstPosOfSum = new HashMap<>();
        firstPosOfSum.put(0, -1);
        int runningSum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                runningSum--;
            } else {
                runningSum++;
            }
            if (firstPosOfSum.containsKey(runningSum)) {
                res = Math.max(res, i - firstPosOfSum.get(runningSum));
            } else {
                firstPosOfSum.put(runningSum, i);
            }
        }
        return res;
    }
}
