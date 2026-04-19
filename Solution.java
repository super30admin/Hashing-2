// Time Complexity :O(N) - we traverse the string once, where N is the length of the string.
// Space Complexity :O(1) - we are using a constant amount of space to store the count and the HashSet, regardless of the input size.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We make use of prefix sum + hashmap to solve this problem.
//  We can treat 0 as -1 and 1 as +1, so that when we encounter a 0, 
// we decrement the running sum (rSum) by 1, and when we encounter a 1, we increment rSum by 1.
// In hashmap we check if the current rSum has been seen before, 
// if it has not been seen before, we add it to the hashmap with the current index as its value.
// If it has been seen before, it means that the subarray between the previous index and the current index has an equal number of 0s and 1s,
// so we calculate the length of this subarray and update our maximum length if necessary.
import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> dict= new HashMap<Integer,Integer>();
            int max=0;
            int rSum=0;
            dict.put(0, -1); 

            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==0)
                {
                    rSum--;
                }
                else
                {
                    rSum++;
                }

                if(!dict.containsKey(rSum))
                {
                    dict.put(rSum, i);
                }
                else
                {
                    max=Math.max(max,i- dict.get(rSum));
                }
            }
        return max;
    }
} 
    

