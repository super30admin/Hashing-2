// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach

import java.util.*;

public class LC525_Contiguous_Array {

        public int findMaxLength(int[] nums) {

            HashMap<Integer, Integer> map = new HashMap<>();

            map.put(0, -1); //dummy node to capture edge case -- VVIMP

            int runningSum = 0;

            int max = 0;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    runningSum -= 1;
                } else {
                    runningSum += 1;
                }

                if(map.containsKey(runningSum)){
                    max = Math.max(max, i - map.get(runningSum));
                } else {
                    map.put(runningSum, i);
                }
            }

            return max;
        }

}
