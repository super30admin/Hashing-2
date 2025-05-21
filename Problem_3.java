
/*
 * Time Complexity - if n = length of the array then Time Complexity: O(n)
 * Space Complexity - Hashmap used to store running sum frequencies, so Space Complexity: O(n)
 * Approach - I used a running sum (rSum) to keep track of sum of elements so far.
 * If (rSum - k) exists in map, it means a subarray with sum = k ends at current index.
 * So, I added the frequency of (rSum - k) to count.
 * I also updated the frequency of rSum in the hashmap for future checks.
 * 
 * This code worked successfully on Leetcode.
 */

import java.util.HashMap;

public class Problem_3 {

    static int subarraySum(int[] nums, int k) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            if (map.containsKey(rSum - k)) {
                count += map.get(rSum - k);
            }
            if (map.containsKey(rSum)) {
                int newCount = map.get(rSum);
                newCount++;
                map.put(rSum, newCount);
            } else {
                map.put(rSum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 1 };
        int k_1 = 2;
        int[] nums2 = { 1, 2, 3 };
        int k_2 = 3;
        System.out.println(subarraySum(nums1, 2));
        System.out.println(subarraySum(nums2, 3));
    }

}
