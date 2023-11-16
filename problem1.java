import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Used running sum concept to get the sum till i index for each element in the array.
//Create a hashmap with key as the running sum and value would be the frequency of the
//running sum. The residual Sum at i - the target will give residual sum for a previous
//index . The sub array between these two point would have the sum same as target.

public class problem1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int resSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i<nums.length; i++){
            resSum += nums[i];
            if(map.containsKey(resSum-k)){
                count += map.get(resSum-k);
            }
            map.put(resSum, map.getOrDefault(resSum,0)+1);
        }
        return count;
    }
}