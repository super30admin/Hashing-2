import java.util.HashMap;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                result = Math.max(result, i - map.get(sum));
            }
        }
        return result;
    }
}
