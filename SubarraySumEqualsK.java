import java.util.HashMap;
import java.util.Map;

//Time Complexity: o(n) -> length of array
//Space Complexity : o(n) -> hashmap

//Your code here along with comments explaining your approach
// Calculate rSum by adding next element of array
// if map contains rsum-k update count by getting the value from map
// if not contains add element with 0 value
// at the update the count by 1
// return count

public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int rSum = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			rSum = rSum + nums[i];

			if (map.containsKey(rSum - k)) {
				count = count + map.get(rSum - k);
				if (map.containsKey(rSum)) {
					map.put(rSum, map.get(rSum) + 1);
				} else {
					map.put(rSum, 1);
				}
			} else {
				if (map.containsKey(rSum)) {
					map.put(rSum, map.get(rSum) + 1);
				} else {
					map.put(rSum, 1);
				}
			}
		}

		return count;
	}

	public int subarraySumOptimized(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int rSum = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			rSum = rSum + nums[i];

			if (map.containsKey(rSum - k)) {
				count = count + map.get(rSum - k);
			}

			if (!map.containsKey(rSum)) {
				map.put(rSum, 0);
			}
			map.put(rSum, map.get(rSum) + 1);
		}

		return count;
	}

}
