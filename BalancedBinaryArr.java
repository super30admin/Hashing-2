// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not as such. Will we remember this in future?
/*
Maintain running sum with index at which it happened
Add dummy value which is 0 runningSum, at index -1: To catch BalancedBinary Arr at beginning
Keep checking with Maximum value and if it is higher for newer one then replace it.

// We have starting and ending indices too. If we are being asked to return the entire max length Balanced Binary Array.
*/


//Running Sum Pattern Program
//x = y+z
//z = x-y

import java.util.Map;
import java.util.HashMap;
public class BalancedBinaryArr {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int maxlen = 0; //Ignorable Auxiliary variable for space complexity
        int runningSum = 0; //Ignorable Auxiliary variable for space complexity
        Map<Integer, Integer> map = new HashMap<>(); // Space(all difference 1's or 0's: O(n))
        map.put(0,-1); //dummy value insertion

        for(int index = 0; index<nums.length; index++){ //Time: O(n)
            if(nums[index] == 1)
                runningSum += 1;
            else //if it were not 1 then it is surely 0. It is mentioned in problem statement.
                runningSum -= 1;

            if(!map.containsKey(runningSum)){
                map.put(runningSum, index); //used index instead of i for better understanding
            }else{
                int priorIndex = map.get(runningSum);
                if(maxlen < index-priorIndex) {
                    maxlen = (index - priorIndex);
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args){
        BalancedBinaryArr binaryArr = new BalancedBinaryArr();
        binaryArr.findMaxLength(new int[]{1,0,1,0,1,1,1,1,0});
    }
}