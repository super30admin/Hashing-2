//Time Complexity - O(n)
//Space Complexity - O(n)
//Ran in Leetcode - Yes
import java.util.HashMap;

public class ContiguousMaxSubArray {
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int runningSum = 0;
		int maxRange = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			int current = nums[idx] == 1 ? 1 : -1;
			runningSum = runningSum + current;
			if (!map.containsKey(runningSum))
				map.put(runningSum, idx);
			else {
				int previousIdx = map.get(runningSum);
				maxRange = Math.max(maxRange, idx - previousIdx);
			}
		}

		return maxRange;
	}

}
