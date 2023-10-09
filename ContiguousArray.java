

import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No


//Approach - Use a HashMap to store the runningSum as key and index at where that happens before in nums
// Increase the runningSum by 1 if ith element is 1 or decrease the runningSum by 1 if it is 0. Then check if that
//runningSum as key in the hashMap and calculate max by using Math.max.
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int runningSum = 0;
        int max = 0;
        for(int i =0; i<nums.length; i++) {
            if(nums[i]==1){
                runningSum +=1;
            }else{
                runningSum -=1;
            }
            if(map.containsKey(runningSum)){
                max = Math.max(max, i - map.get(runningSum));
            }else{
                map.put(runningSum, i) ;
            }

        }
        return max;
    }
}
