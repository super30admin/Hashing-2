/**** Method 1 ****/
//Time Complexity: O(n^3)
//Space Complexity: O(1)

//Unsuccessful while submitting in LeetCode, gave TLE

// Generate all the subArrays and for each and everyone check the no of zeros and ones in the them. If both are equal store the length of the subarray in the ans.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//So using prefixSum and hashmap,for each 0 we do sum-1 and for each 1 we do sum+1 as we only have 0s and 1s doing this gives sum as zero for equal no of zero's and one's, storing the prefix with index at each values of the arr, if we found the prefixSum existed in hashmap,  that means the sum from index we found the sum to current index is zero. So we add it our ans.

import java.util.HashMap;

public class _525_Contiguous_Array {

  /**** Method 1 ****/
  public int findMaxLength1(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1) {
      return 0;
    }

    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int zeros = 0;
        int ones = 1;

        for (int k = i; k <= j; k++) {
          if (nums[k] == 0) {
            zeros++;
          } else {
            ones++;
          }
        }

        if (zeros == ones) {
          ans = Math.max(ans, j - i + 1);
        }
      }
    }

    return ans;
  }

  public int findMaxLength2(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1) {
      return 0;
    }

    int ans = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        sum -= 1;
      } else {
        sum += 1;
      }

      if (map.containsKey(sum)) {
        ans = Math.max(ans, map.get(sum) - i - 1);
      } else {
        map.put(sum, i);
      }
    }

    return ans;
  }
}
