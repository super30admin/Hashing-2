/*
 * TC: O(n)
 * SC: O(n)
 */ 
import java.util.HashMap;
class longestsubarraysum {
    public int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == k)
                return 1;
            else
                return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            if (map.containsKey(rSum)) {
                map.put(rSum, map.get(rSum) + 1);
            } else
                map.put(rSum, 1);
                
            if (map.containsKey(rSum - k)) {
                cnt = cnt + map.get(rSum - k);
            }
            //map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
        return cnt;
    }
}