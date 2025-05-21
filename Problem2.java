// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class Problem2 {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
            else
                zero--;
            // if zero is 0, it means we have equal number of 0's and 1's
            if (zero == 0)
                max = i + 1;

            if (!map.containsKey(zero))
                map.put(zero, i);
            else
                max = Math.max(max, i - map.get(zero));

        }

        return max;
    }

    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        int[] nums1 = { 0, 1 };
        System.out.println(obj.findMaxLength(nums1)); // Output: 2
        int[] nums2 = { 0, 1, 0 };
        System.out.println(obj.findMaxLength(nums2)); // Output: 2
    }
}
