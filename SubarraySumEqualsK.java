import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // rsum : count

        int rsum = 0, result = 0;
        map.put(0, 1);

        for (int num : nums) {
            rsum += num;

            int cmp = rsum - k;
            if (map.containsKey(cmp)) {
                result += map.get(cmp);
            }
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }

        return result;
    }
}

/**
 * Approach: Compute running sum along the array and track the rsum (key) and its count (value) in a hashMap
 * If (rsum-k) already exists in the map, that means we have one of our subarray sum equals k, so increment the result with that of the count saved in the hashmap
 */
//TC: O(n) We traverse the array once
//SC: O(n) In the worst case, we store all possible rsum values in the HashMap.
