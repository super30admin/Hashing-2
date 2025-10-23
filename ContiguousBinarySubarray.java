import java.util.HashMap;

/**
 * 
 */

/**
 * @author Aditya sinha
 *
 */
//we will increment running sum for every 1 and decrement it for every 0 and see if same running same appears again
//Time Complexity ; O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
public class ContiguousBinarySubarray {
	public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int rSum = 0;
        map.put(0, -1); 

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) rSum--;
            else rSum++;

            if (map.containsKey(rSum)) {
                max = Math.max(max, i - map.get(rSum));
            } else {
                map.put(rSum, i);
            }
        }

        return max;
    }
}
class ContiguousBinarySubarrayMain {
	public static void main(String[] args) {
		int[] nums = {0,1};
		ContiguousBinarySubarray cbs = new ContiguousBinarySubarray();
		System.out.println("Contiguous Binary Subarray - " + cbs.findMaxLength(nums));
	}
}