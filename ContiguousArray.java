// ## Problem2 (https://leetcode.com/problems/contiguous-array/)

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                ans = Math.max(ans, i - map.get(count));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ContiguousArray obj = new ContiguousArray();
        int[] nums1 = { 0, 1 };
        int[] nums2 = { 0, 1, 0 };
        int[] nums3 = { 0, 0, 0, 1, 1, 1, 1, 1, 0 };

        System.out.println(
                "maximum length of a contiguous subarray with an equal number of 0 and 1: " + obj.findMaxLength(nums1));
        System.out.println("Tmaximum length of a contiguous subarray for nums2: " + obj.findMaxLength(nums2));
        System.out.println("maximum length of contiguous subarray for nums3: " + obj.findMaxLength(nums3));

    }
}
