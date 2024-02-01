import java.util.HashMap;

//Running Sum Pattern
//Use a HashMap to store the running sum and its first occurance index in the String S 
//Increase the rSum by 1 when 1 is founf and decrement by 1 when 0 is found
//By checking the map for each new running sum calculated, get the length of the subarray with balanced 0's and 1's
//If the running sum is greater than the previously obtained balanced subarray length, save it to variable max

// Time Complexity : O(n) for iterating through the entire int array
// Space Complexity : O(n) for using map to store running sum
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, identifying the 
public class Problem2_ContiguousSubarray {
    public int findMaxLength(int[] nums) {
        int n=nums.length, rSum=0, max=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                rSum++;
            }else{
                rSum--;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i-map.get(rSum));
            }else{
                map.put(rSum, i);
            }
        }
        return max;
    }
}