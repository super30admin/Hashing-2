// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class Problem1 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap();
        int rsum = 0, count = 0;
        remainderMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];

            if (remainderMap.containsKey(rsum - k)) {
                count += remainderMap.get(rsum - k);
            }
            remainderMap.put(rsum, remainderMap.getOrDefault(rsum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] nums1 = { 1, 1, 1 };
        int k = 2;
        System.out.println(obj.subarraySum(nums1, k)); // Output: 2
        int[] nums2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println(obj.subarraySum(nums2, k2)); // Output: 2

    }
}
