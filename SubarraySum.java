import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(N) where N is the length of the nums in array
//Space Complexity: O(N) in worse case where the sum of arrays doesn't repeat and there will be unique entry for each
//Did this code successfully run on Leetcode : Yes

/**
 * Since we have to find the number of subarrays which have the specific sum, using the hashing technique to keep the track of the number of running sum occurrences in the array.
 * So that we can check how many matches we have on the current index which has the target sum when iterating through the numbers
 */
public class SubarraySum {

    static int numsOfSubArraySum(int[] nums, int target) {
        Map<Integer, Integer> countBySum = new HashMap<>();
        // base case where the match is on first index
        countBySum.put(0, 1);

        int count =0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            int diff = sum - target;
            if (countBySum.containsKey(diff)) {
                count += countBySum.get(diff);
            }

            countBySum.put(sum, countBySum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numsOfSubArraySum(new int[] {3,4,7,2,-3,1,4,2,0,1}, 7));
    }
}
