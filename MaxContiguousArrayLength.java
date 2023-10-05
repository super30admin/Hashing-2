/* Time Complexity : O(n)
 * 	n - length of the input array, as we have to traverse through it*/
/* Space Complexity : O(n)
 * 	n - size of HashMap - due to different rSum */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*Logic: 
 * 	Initialize max to 0 and a HashMap with key as running sum (rSum) and value as the index of that rSum.Add dummy rSum 0 a index  -1
 * 	If value in array is '0' decrement rSum by '1', if value '1' increment rSum by '1'
 * 	If map doesn't contains rSum, insert the rSum and index pair
 * 	else if difference b/n current and first index stored in map is grater than max, update max value*/ 


import java.util.HashMap;

public class MaxContiguousArrayLength {
	
	public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        int rSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum -= 1;
            }else{
                rSum += 1;
            }
            if(map.containsKey(rSum)){
                if(max < i - map.get(rSum))
                    max = i - map.get(rSum);
            }else{
                map.put(rSum, i);
            }
        }
        return max;    
    }

}
