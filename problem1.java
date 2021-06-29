// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for(int start =0; start <nums.length; start++){
            int sum = 0;

            for(int end= start; end<nums.length; end++){

                sum += nums[end];

                if(sum == k){
                    count++;
                }
            }
        return count;
    }
}