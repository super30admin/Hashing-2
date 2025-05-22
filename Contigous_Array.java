// TC: O(n)
// SC: Hashmap is used to store diff and index - O(n)
// Approach: Find running sum / prefix Sum of the array

import java.util.HashMap;

public class Contigous_Array {

  public int findMaxLength(int[] nums) {

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int rSum = 0;
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        rSum -= 1;
      } else {
        rSum += 1;
      }

      if (map.containsKey(rSum)) {
        max = Math.max(max, i - map.get(rSum));
      } else {
        map.put(rSum, i);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    Contigous_Array ca = new Contigous_Array();

    int[] nums = new int[] { 0, 1, 1, 1, 1, 1, 0, 0, 0 };

    System.out.println(ca.findMaxLength(nums));
  }
}
