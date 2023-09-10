// ## Problem2 (https://leetcode.com/problems/contiguous-array/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// approach: we tallied the sum of the elements from starting of the array where 0 meant -1 and 1 meant +1 in the sum. Now wherever the sum at two indexes is identical it means that there are equal number of 1 and 0 between these numbers. Therefore we stored earliest occcurences of these numbers in a hashmap and used it to find the longest length at each point of time while traversing the array


class Solution {
    public int findMaxLength(int[] nums) {

        int max=0;

        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                sum-=1;
            }
            else
            {
                sum+=1;
            }
            if(m.containsKey(sum))
            {
                if(i-m.get(sum)>max)
                {
                    max = i-m.get(sum);
                }
            }
            else
            {
                m.put(sum,i);
            }
        }
        return max;
        
    }
}
