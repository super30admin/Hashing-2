// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach
public class Problem1 {
	 public int subarraySum(int[] nums, int k) {
	        int count = 0;
	        int[] sum = new int[nums.length+1];
	        sum[0] = 0;
	        for(int i = 1; i<=nums.length; i++)
	            sum[i] = sum[i-1] + nums[i-1];
	        for(int start = 0; start<nums.length; start++){
	            for(int end = start+1; end <= nums.length; end++){
	                if(sum[end] - sum[start] == k)
	                    count++;
	            }
	        }
	        return count;
	    }
}
