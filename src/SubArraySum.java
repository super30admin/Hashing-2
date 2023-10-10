// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
import java.util.HashMap;

public class SubArraySum {
    public int subArraySum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int rSum = 0;
        for(int i=0;i<nums.length; i++){
            rSum+=nums[i];
            if(map.containsKey(rSum-target)){
                count+=map.get(rSum-target);
            }
            map.put(rSum, map.getOrDefault(rSum, 0));
        }
        return count;
    }
}
