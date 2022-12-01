// Time Complexity : O(n)
// Space Complexity : O(n)

/*
 * We find the running sum of the array (decrement for 0 and increment for 1) and store that value in hashmap.
 * Then if the running sum already exist in hashmap then get the length of the array and return the max length.
 */

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                runningSum --;
            }
            else{
                runningSum ++;
            }
            if(!map.containsKey(runningSum)){
                map.put(runningSum, i);
            }
            else{
                maxLength = Math.max(i - map.get(runningSum), maxLength);
            }
        }
        return maxLength;
    }    
}
