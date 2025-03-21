import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
We calculate a running sum where we subtract 1 for every 0 and add 1 for every 1.
If the running sum becomes 0 at any point, it means the subarray from the start up to that index is balanced.
To find balanced subarrays that don’t start from index 0, we need to check if the same running sum has appeared before.
The running sum tells us how many extra 1s or 0s we have seen so far.
For example, if at some index the running sum is 2, it means we have 2 extra 1s compared to 0s.
If this same running sum appeared earlier at some index, it means the subarray between those two indices must be balanced because
 the extra digits have canceled each other out.
To efficiently check if a running sum has appeared before—and to ensure we find the longest possible subarray—we use a hashmap to store the first occurrence of each running sum.
This allows us to retrieve previous occurrences in constant time and calculate the maximum length of a balanced subarray.
*/
class ContigiousSubArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        int rSum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                rSum--;
            else
                rSum++;
            if(map.containsKey(rSum))
            {
                int index=map.get(rSum);

                max=Math.max(max,i-index);
            }
            else
            {
                map.put(rSum,i);
            }
        }
        return max;
    }
}