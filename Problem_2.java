/*
 * Time Complexity - if n = length of the array then Time Complexity: O(n)
 * Space Complexity - Hashmap used to store diff and index, so Space Complexity: O(n)
 * Approach - I used count_0 and count_1 to track number of 0s and 1s.
 * I calculated the difference between count_0 and count_1 at each index.
 * If this difference was seen before, that means between those two indices we had equal 0s and 1s.
 * So, I updated the max length using difference of current index and stored index.
 * If not seen before, I stored it in the map with current index.
 * 
 * This code worked successfully on Leetcode.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem_2 {

    static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count_1 = 0;
        int count_0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count_1++;
            }
            if (nums[i] == 0) {
                count_0++;
            }
            int diff = count_0 - count_1;
            if (map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 0 };
        int[] nums2 = { 0, 1 };
        int[] nums3 = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };

        System.out.println(findMaxLength(nums1));
        System.out.println(findMaxLength(nums2));
        System.out.println(findMaxLength(nums3));
    }

}
