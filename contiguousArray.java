// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We store 0,-1 in map first to avoid missing any edge cases. 
 * We have a running sum and check if the number is 0 or 1. 
 * We increment the sum by 1 when we encounter 1 and reduce by 1 when we find 0.
 * If present, we check the max of length by computing the position of previous occurance and current occurance and comparing it with longest length max. 
 * 
 */
public class contiguousArray {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int max=0; 
            int rsum =0; 
            map.put(0,-1);
            for(int i=0; i < nums.length; i++){
                if(nums[i] == 1)
                rsum++; 
                else 
                rsum--;
            if(map.containsKey(rsum)){
                max = Math.max(max, i-map.get(rsum));
            }
            else {
                map.put(rsum, i);
            }
            }
            return max;
}
}
