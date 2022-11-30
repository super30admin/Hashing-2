import java.util.HashMap;
import java.util.Map;

//Time Complexity :O(N) because we traverse the whole string ones
//Space Complexity :O(N)
//Did this code successfully run on Leetcode :Yes


public class ContigousSubArray {
	 // Running sum pattern 
    // 0 -> -1 in running Sum
    //1 -> +1 in running Sum
    // Sum we will save in key and in value we will save first index of that running sum
    // we have to save (0,-1) so that cases of (0,1,0,1)
    public int findMaxLength(int[] nums) {
        int runningSum = 0;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                runningSum-=1;
            }else
                runningSum+=1;
            if(map.containsKey(runningSum)){
                result = Math.max(result,i - map.get(runningSum));
            }
            else
                map.put(runningSum,i);
            }
        return result;
    }
}
