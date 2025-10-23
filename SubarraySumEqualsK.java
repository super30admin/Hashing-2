import java.util.HashMap;

/**
 * 
 */

/**
 * @author Aditya sinha
 *
 */
//we will use hashmap and runningsum and check if rsum - k was seen before
//Time Complexity ; O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int rSum = 0;
        int result = 0;

        map.put(0, 1);

        for (int num : nums) {
            rSum += num;
            int cmp = rSum - k;
            if (map.containsKey(cmp)) {
                result += map.get(cmp);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }
}

class SubarraySumEqualsKMain {
	public static void main(String[] args) {
		int[] nums = {1,1,1};
		int k = 2;
		SubarraySumEqualsK ssek = new SubarraySumEqualsK();
		System.out.println("Subarray Sum Equals K - " + ssek.subarraySum(nums, k));
	}
}