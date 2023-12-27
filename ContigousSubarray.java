
/*
* Approach:
*  1. Calculate the prefix sum by assuming:
           0's contribution as -1 
           1's contribution as 1
* 
*  2. Once we have prefix sum, store the sum and index in hashmap.
* 
*  3. If current sum is already found in hashmap, 
        calculate the index difference for the subarray length.

    Dont replace the index value if sum is found again,
        because we need longest length.
    Therefore, first occurrence of sum and repeatition occurence,
        gives the longest length.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
    if nums contains all 1's or all 0's
* 
*/
import java.util.HashMap;

public class ContigousSubarray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        int maxLength = 0;

        int sum = 0;

        hmap.put(sum, -1);

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0)
                sum--;
            else
                sum++;

            if (hmap.containsKey(sum)) {
                int currLength = index - hmap.get(sum);

                maxLength = Integer.max(maxLength, currLength);
            } else {
                hmap.put(sum, index);
            }
        }

        return maxLength;
    }
}
