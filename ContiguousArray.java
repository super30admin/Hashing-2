// Time Complexity : O(n) where n is the number of elements in the input array nums.
// Space Complexity : O(n) as we might have to store all elements in the hashmap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
* Problem: Contiguous array
* */

/*
* Approach: Using HashMap and Running Sum
* In this approach, we keep a track of running sum by incrementing the sum by 1 if element is 1 and
* decrementing the sum by 1 if element is 0. We store the sum corresponding to an index in map. If
* we encounter the same sum again, we just take the difference between the current index and the index
* of the already stored sum which should give us the max length of a contiguous balanced array.
* */

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int rSum = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                rSum--;
            } else {
                rSum++;
            }

            if (map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }

        return max;
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};
        int[] nums3 = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        
        ContiguousArray contiguousArray = new ContiguousArray();
        System.out.println(contiguousArray.findMaxLength(nums1));
        System.out.println(contiguousArray.findMaxLength(nums2));
        System.out.println(contiguousArray.findMaxLength(nums3));
    }
}
