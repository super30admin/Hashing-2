// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : cleared up in class


// Your code here along with comments explaining your approach
import java.util.HashMap;

class Problem1 {

    /** find subarray sum equal to k */
    public int subarraySum(int[] nums, int k) {
        
        // storing continous sum of subarray and frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // intial 
        int sum = 0;
        int count = 0;

        // required as 0 + sum = sum
        map.put(0, 1);
        
        // iterate array
        for(int i=0; i<nums.length; i++){
            // calculate sum
            sum += nums[i];
            
            // the conditions should be same order 1, 2

            // 1. find k is present in calculate sum
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            
            // 2. Update frequency of the sum
            if(!map.containsKey(sum)){
                map.put(sum, 1);
            }else{
                int frequency  = map.get(sum);
                frequency++;
                map.put(sum, frequency);
            }
        }

        // return count
        return count;
        
    }
}
