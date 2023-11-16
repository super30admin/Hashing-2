import java.util.HashMap;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//use a hashmap (rSumMap) to store the running sum of 1s and -1s encountered
//in the array, initialized with a sum of 0 at index -1.
//checks if the running sum has been encountered before and updates the
//maximum length of contiguous subarrays with equal 0s and 1s.

class Problem2 {
    public int findMaxLength(int[] nums) {
        int rSum = 0 ;
        int maxLength = 0;
        HashMap<Integer,Integer> rSumMap = new HashMap<Integer,Integer>();
        rSumMap.put(0,-1);
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i] == 1)
                rSum += 1;
            else
                rSum -= 1;

            if(rSumMap.containsKey(rSum)){
                maxLength = Math.max(maxLength, i-rSumMap.get(rSum));
            } else{
                rSumMap.put(rSum, i);
            }
        }
        return maxLength;
    }
}