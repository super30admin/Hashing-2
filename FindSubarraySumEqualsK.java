import java.util.HashMap;

//Time Complexity - O(n)
//Space Complexity - O(n)
//Ran in Leetcode - Yes

public class FindSubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
	        HashMap<Integer,Integer> map = new HashMap<>();
			map.put(0, 1);
			int currentSum = 0;
			int numberOfSubArrays =0;
			for( int i=0;i<nums.length;i++) {
				currentSum = currentSum + nums[i];
				int previousValue = currentSum-k;
				if(map.containsKey(previousValue)) {
					int noOfOccurrence = map.get(previousValue);
					numberOfSubArrays += noOfOccurrence;
				}
				//if(!map.containsKey(previousValue)) 
				//	map.put(currentSum, 1);
				//else 	 		
					map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
				
			}
			
			return numberOfSubArrays;
	}

}
