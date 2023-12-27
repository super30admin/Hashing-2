/*
* Approach:
*  1. Maintain hashmap to search for previous sum and their occurences
* 
*  2. If (current sum - target) is found in the hashmap, that means 
        we can form a subarray with given target.
* 
*  3. Keep track of count and increment the total subarray count by 
        number of occurences of the compliment(current sum - target)
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
    because we can get n different values if total sum is < target 
* 
*/
import java.util.HashMap;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        int prefSum = 0;

        hmap.put(prefSum, 1);

        int count = 0;

        for (int num : nums) {
            prefSum += num;

            int diff = prefSum - k;

            if (hmap.containsKey(diff))
                count += hmap.get(diff);

            hmap.put(prefSum, hmap.getOrDefault(hmap, 0) + 1);
        }

        return count;
    }
}
