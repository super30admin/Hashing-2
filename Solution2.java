/*
 * Leetcode Problem : https://leetcode.com/problems/contiguous-array/
 */
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I maintain running sum for each element. I take a HashMap where I store runningSum and their earliest occurrence. At first, I add
 * (0,-1) into the hashmap as runningSum is 0 initially. Now while iterating through the array, I add 1 to runningSum for every
 * 1 I come across in the array. Similarly I subtract -1 for every 0 I come across. If runningSum is already present, I 
 * subtract the current index from the index of runningSum's earliest occurrence (stored in HashMap) and I check if it is greater than len 
 * which is initially set to 0. If so, I update len to the difference of current index and runningSum's earliest index. If not present
 * in the Hashmap, I add the runningSum as the key and index as value. At the end, I return the total length.
 */

class Solution {
    public int findMaxLength(int[] nums) {
        int runningSum = 0;
        int len = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> runningMap = new HashMap<>();
        map.put(0,-1);
        runningMap.put(1,1);
        runningMap.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            runningSum += runningMap.get(nums[i]);
            if(map.containsKey(runningSum))
            {
                len = Math.max(len, i-map.get(runningSum));
            }
            else
            {
                map.put(runningSum,i);
            }
        }
        return len;

    }
}