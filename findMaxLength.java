// Time Complexity : O(n), where n is the length of the array.
// Space Complexity : O(n), since the HashMap will have at most n elements.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Create a HashMap to store the running um and the first occurance of index.
 * 2. Iterate through the array and check if the sum is present in the HashMap.
 * 3. If it is present, update the max length.
 * 4. If it is not present, add the sum and the index to the HashMap.
 * 5. Return the max length.
 */

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i<len; i++){
            if(nums[i] == 0){
                sum--;
            }else{
                sum++;
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                max = Math.max(max, i - map.get(sum));
            }
        }

        return max;
    }
}