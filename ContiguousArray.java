import java.util.*;
// Time Complexity : O(N)
// Space Complexity : O(N)
// n being max size of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was new to Running sum technique

class ContiguousArray {

    public static void main(String[] args){

    }

    private static int findMaxLength(int[] nums) {
      if(nums == null || nums.length == 0) return 0;

      int maxLength = 0;
      HashMap<Integer, Integer> hMap = new HashMap<Integer,Integer>();
      int rSum = 0;

      for(int i = 0; i < nums.length; i++){
        if(nums[i] == 0){
          rSum -= 1;
        }else{
          rSum += 1;
        }
        if(hMap.containsKey(rSum)){
          maxLength = Math.max(maxLength, i - hMap.get(rSum));
        }else{
          hMap.put(rSum, i);
        }



      }



      return maxLength;
    }
}
