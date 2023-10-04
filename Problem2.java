// Problem2 (https://leetcode.com/problems/contiguous-array/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -
import java.util.*;
class Solution {

  public int findMaxLength(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    //runningSum
    int rSum = 0;
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        rSum += 1;
      } else {
        rSum -= 1;
      }
      if (map.containsKey(rSum)) {
        max = Math.max(max, i - map.get(rSum));
      } else {
        map.put(rSum, i);
      }
    }
    return max;
  }
}

public class Problem2 {

  public static void main(String[] args) {
      int[] array = new int[] {0,1,1,0,1,0,0,1,0,0};
      Solution sol = new Solution();
      System.out.println(sol.findMaxLength(array));
      
  }
}
