// Time Complexity : O(n), n is the length of the array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * we approach this problem by calculating the subarrays and checking its sum, but to checking every subarray will lead ot O(n^2)
 * To reduce to O(n), we are using the running sum approach.
 * we calculate the running sum for every integer in the array, for 0 we reduce the sum and for 1 we increment the sum.
 * If the sum exists, we calculate the maximum number of balanced 0and1 and store it in result.
 * If does not exists, we add it to the map with the index.
 * max stores - evry rsum corresponding to its index.
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        
        int result = 0 , rSum = 0 ;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0, -1);

        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                rSum--;
            }
            else{
                rSum++;
            }
            if(map.containsKey(rSum))
            {
                result = Math.max(result, i - map.get(rSum));
            }
            else{
                map.put(rSum,i);
            }
        }

        return result;
    }
}contiguousArray{

}
