import java.util.HashMap;
import java.util.Map;

//Time Complexity :O(N) because we traverse the whole string ones
//Space Complexity :O(N)
//Did this code successfully run on Leetcode :Yes

public class SubArraySumEqualsK {
	  public int subarraySum(int[] nums, int k) {
	        int runningSum = 0;
	        int result = 0;
	        Map<Integer,Integer> map = new HashMap<>();
	        map.put(0,1);
	        for(int i=0;i<nums.length;i++){
	           runningSum+= nums[i];
	           if(map.containsKey(runningSum-k)){
	               result+=map.get(runningSum-k);
	           }
	           map.put(runningSum,map.getOrDefault(runningSum,0)+1);
	        }

	    return result;
	    }
}
