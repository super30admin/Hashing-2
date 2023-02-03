import java.util.HashMap;
import java.util.Map;

//Time Complexity : o(n) n is number length of array
//Space Complexity : o(n) for using map
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

//	Your code here along with comments explaining your approach
// calculate running sum, increment for 1 and decrement for 0 and store in map
// check for every element in array if the running sum is in map and 
// calculate z-x =y  to find the balanced array and return max length
//

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int rSum = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				rSum--;
			else
				rSum++;

			if (map.containsKey(rSum))
				max = Math.max(max, i - map.get(rSum));
			else
				map.put(rSum, i);
		}
		return max;

	}
}
