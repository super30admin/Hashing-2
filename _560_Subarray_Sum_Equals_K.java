/**** Method 1 ****/
//Time Complexity: O(n^2)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// Try to check all SubArrays and keeping track of their sum to check if they match k. If yes we increment ans. After the loop end we return the ans.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// So we use prefix sum and hashmap, at each index we calculate prefix sum and add to map with it's occurrence, before check if prefixSum - k is present, as if it is present the from that values to current index the sum is k, so we add it to our answer.

import java.util.HashMap;

public class _560_Subarray_Sum_Equals_K {

  public static void main(String[] args) {}

  /*** Method 1 ***/
  public int subarraySum1(int[] arr, int k) {
    int n = arr.length;
    int ans = 0;

    for (int i = 0; i < n; i++) {
      int sum = arr[i];
      if (sum == k) {
        ans++;
      }
      for (int j = i + 1; j < n; j++) {
        sum += arr[j];
        if (sum == k) {
          ans++;
        }
      }
    }
    return ans;
  }

  /*** Method 2 ***/
  public int subarraySum3(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int ans = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return ans;
  }
}
