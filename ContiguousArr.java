// Convert 0s to -1s to use running sum technique
// Track the first occurrence of each running sum in a HashMap
// If the same running sum appears again, the subarray in between is balanced
// Use the difference of indices to calculate the maximum length
// Time: O(n), Space: O(n) — where n is the length of the array

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>(); // rSum : Index

        int max = 0;

        int rSum = 0;

        map.put(0, -1); // the array is balanced from 0th index

        int start = 0, end = 0;

        for(int i=0; i<n; i++) {
            int num = nums[i];
            if(num == 0) rSum--; // decrement by 1 if value is 0
            else rSum++; // increment by 1 if value is 1

            if(map.containsKey(rSum)) {
                if(max < i - map.get(rSum)) {
                    start = map.get(rSum) + 1; // subarray start + 1 idx
                }
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i); // at what index run sum happening
            }
        }
        return max;
    }
}
