// Time Complexity: O(n) 
// Space Complexity: O(n) 
// Did this code successfully run on Leetcode? Yes
// Any problem you faced while coding this? No

// Approach:
// We use a running sum (rsum) that increments for 1s and decrements for 0s, treating the array like a balance problem.
// If the same rsum appears again at a later index, it means the number of 0s and 1s in that subarray is equal.
// We store the first occurrence of each rsum in a HashMap and use the distance between current and stored index to track the max length.


import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>(); // rsum : index(first occurence to find the longest subarray)
        map.put(0, -1);

        int rsum = 0, max = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) rsum--;
            else rsum++;

            if(map.containsKey(rsum)){
                max = Math.max(max, i - map.get(rsum));
            }else{
                map.put(rsum, i);
            }
        }
        return max;
    }
}
