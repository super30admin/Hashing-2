/*
Problem - Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Approach - We increment running sum for every 1 and decrement it for every 0.
If the same running sum appears again, it means the subarray in between is balanced.
Track the longest such subarray using a hashmap.
Time Complexity - O(n)
Space Complexity - O(n)
 */

import java.util.HashMap;

public class BinarySubArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
      int maxLength = 0;
      int rSum = 0;
      map.put(0, -1);
      for (int i = 0; i < nums.length; i++) {
        int  num = nums[i];
        // if the num is 0 decrease the rsum by 1 if 1 increase the rsum by 1
        rSum = (num ==0)? rSum+1:rSum-1;
        if(map.containsKey(rSum)){
            maxLength = Math.max(maxLength, i-map.get(rSum));
        }
        else  {
            map.put(rSum, i);
        }

      }
      return maxLength;
    }

}
