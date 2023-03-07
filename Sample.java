// Time Complexity :O(N^2)
// Space Complexity : (O(1))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Did not understand the optimised Solution

// Your code here along with comments explaining your approach

class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        for(int i=0;i<nums.length;i++){
            int runningSum = 0;
            for(int j=i;j<nums.length;j++){
                runningSum+=nums[j];
                if(runningSum==k)
                    answer++;
            }
        }
        return answer;
    }
}