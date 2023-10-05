/* Time Complexity : O(n)
 * 	n - length of the input array, as we have to traverse through it*/
/* Space Complexity : O(n)
 * 	n - size of HashMap - due to different rSum */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*Logic: 
 * 	Initialize count(total no. of sub-arrays with sum as k) to 0 and 
 *  a HashMap with key as running sum (rSum) and value as the no. of times the rSum occurred.Add dummy rSum 0 a it's occurrence as 1
 * 	Loop through the array and calculate rSum at each index. If the HashMap contains complement(value at that index - k) as the key add the no. of occurrences of that complement to the count.
 *  If map doesn't contains rSum, insert the rSum and 1 (1st occurrence of that rSum)
 * 	else update the occurrence of that rSum by incrementing it by '1' */ 

import java.util.HashMap;

public class SubArrSumEqualsK {
	public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++){
            rSum += nums[i];
            if(map.containsKey(rSum - k)){
                count += map.get(rSum - k);
            }

            if(!map.containsKey(rSum)){
                map.put(rSum, 1);
            }else{
                map.put(rSum, map.get(rSum) + 1);
            }
        }
        return count;
    }
}
