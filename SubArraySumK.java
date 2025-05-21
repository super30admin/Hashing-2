// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
import java.util.HashMap;

class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            rSum = rSum + nums[i];
            if (map.containsKey(rSum - k)) {
                result = result + map.get(rSum - k);
            }

            if (!map.containsKey(rSum)) {
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1);
            }
        }

        return result;
    }
}

