//Time Complexity: O(n) because we are iterating over the nums array
//Space Complexity: O(n) because we are storing the running sum
//Did this code successfully run on Leetcode : Yes

//Approach: We will maintain a data member sum which will be the running sum of the elements in the nums array (add 1 for 1, -1 for 0)
//max data member to count the sub arrays which are balanced
//a map to maintain the running sum and its initial index
//we will calculate the running sum until that index and check if that running sum has occurred before,
// if yes, calculate the difference b/w current index and previous index, which will be the max length of the balanced array for that running sum
// else put the running sum in the map along with the current index
import java.util.HashMap;
import java.util.Map;

/**
 * Finds the max length of the balanced sub array with equal no of 0s and 1s
 */
public class ContiguousArray {

    /**
     *
     * @param nums the nums array
     * @return     the max length of the balanced sub array with equal no of 0s and 1s
     */
    public int findMaxLength(int[] nums) {
        int sum = 0, max = 0;
        final Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1); // running sum is 0 at index -1 (to handle edge cases where you get a valid balanced sub array at index 1 (1, 0) or (0, 1)

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum -= 1;
            else sum += 1;

            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }

            final int current = i - sumMap.get(sum);
            max = Math.max(max, current);
        }

        return max;
    }

    public static void main(String[] args) {
        final ContiguousArray contiguousArray = new ContiguousArray();
        System.out.println(contiguousArray.findMaxLength(new int[] {1, 1, 1, 0, 0, 1, 0, 1, 1})); //return 6
        System.out.println(contiguousArray.findMaxLength(new int[] {0, 1, 1, 1, 1, 1, 0, 0, 0})); //return 6
        System.out.println(contiguousArray.findMaxLength(new int[] {0, 1, 0})); //return 2
        System.out.println(contiguousArray.findMaxLength(new int[] {0, 1})); //return 2
    }
}
