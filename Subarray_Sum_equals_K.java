// TC: O(n)
// SC: Hashmap is used to store running sum frequencies  - O(n)
// Approach: Find running sum / prefix Sum of the array

import java.util.HashMap;

public class Subarray_Sum_equals_K {

  public int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0;
    int rSum = 0;

    for (int i = 0; i < nums.length; i++) {
      rSum += nums[i];

      if (map.containsKey(rSum - k)) {
        count += map.get(rSum - k);
      }
      if (!map.containsKey(rSum)) {
        map.put(rSum, 0);
      }
      map.put(rSum, map.get(rSum) + 1);
    }
    return count;
  }

  public static void main(String[] args) {

    Subarray_Sum_equals_K sa = new Subarray_Sum_equals_K();

    int[] nums = new int[] { 1, 2, 3 };
    int k = 3;

    System.out.println(sa.subarraySum(nums, k));
  }
}
