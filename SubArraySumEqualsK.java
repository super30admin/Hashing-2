//Time Complexity: O(n) because we are iterating over the nums array
//Space Complexity: O(n) because we are storing the running sum
//Did this code successfully run on Leetcode : Yes

//Approach: We will maintain a data member sum which will be the running sum of the elements in the nums array
//count data member to count the sub arrays whose sum equals k
//a map to maintain the running sum and its frequency
//Let's say we have an array [3, 4, 7, 2, -3, 1, 4, 2, 0, 1], the running sum until index 2 is 14, by then we will have found two
//sub arrays [3, 4], [7] because the sum of those is 7 (k), and we are finding the frequency of running sum - k in the hash map
//which means, that the map will have 0 sum with 1 frequency by default to account for [3, 4] : running sum = 7, 7 - 7 = 0, 0 occurred once, count -> 1
//for index 2, the running sum will be 14, 14 - 7 -> 7, 7 occurred once, count will be 2 (don't forget to put the frequency of the running sum in the map)
import java.util.HashMap;
import java.util.Map;

/**
 * Find the count of sub arrays that equal k
 */
public class SubArraySumEqualsK {

    /**
     *
     * @param nums the nums array
     * @param k    k
     * @return     the count of sub arrays where the sum equals k
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        final Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }

            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        final SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        System.out.println(subArraySumEqualsK.subarraySum(new int[] {3, 4, 7, 2, -3, 1, 4, 2, 0, 1}, 7)); //return 7
        System.out.println(subArraySumEqualsK.subarraySum(new int[] {3, 4, 7, 2, -3, 1, 4, 2, 0, 1}, 9)); //return 1
        System.out.println(subArraySumEqualsK.subarraySum(new int[] {1, 1, 1}, 2)); //return 2
        System.out.println(subArraySumEqualsK.subarraySum(new int[] {1, 2, 3}, 3)); //return 2
    }
}
