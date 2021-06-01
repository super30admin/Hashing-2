//TC : O(n^2) where n is the length of the string given
//SC : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//the approach taken is that every subarray is considered and the sum is calculated on the go.
//if the sum is equal to k, then increase the counter.
public class SubArraySumEqualsk {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
