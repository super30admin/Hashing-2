// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
import java.util.HashMap;

class Problem2 {

    /** find max length where Os and 1s are equal */
    public int findMaxLength(int[] nums) {
        
        // map to store sum and first occurence i.e index
        HashMap<Integer, Integer> map = new HashMap<>();

        // initial value
        int sum = 0;
        int count = 0;

        // base case as nums value is zero at the start
        map.put(0, -1);
        
        // iterate 
        for(int i=0; i<nums.length; i++){
            
            // subtract 1 on '0'
            if(nums[i]==0)
                sum--;
            // add 1 on '1'
            else
                sum++;
            
            // check if the sum is present and update count to longest sequence
            if(map.containsKey(sum)){
                // here index (i) - first occurence
                count = Math.max(count, i-map.get(sum));
            }// it is first occurence
            else{
                map.put(sum, i);
            }
        
         }
         // max length
         return count;
    }
}