// ## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// approach: We maintained the running sum. And a hashmap which stores the running sum and number of times the running sum occured. Whenever we iterate to the next element in the array we check if the running sum minus k exists in the hashmap, if it does that means from the location where running sum-k exist to the current location the sum of elements is k.

class Solution {
    public int subarraySum(int[] nums, int k) {


        int sum = 0;
        int count =0;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0, 1);

        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            if(m.containsKey(sum-k))
            {
                count += m.get(sum-k);
            }
            
            

            if(!m.containsKey(sum))
            {
                m.put(sum,0);
            }
            int temp = m.get(sum) +1;
            m.put(sum,temp);
            
        }
        return count;
    }
}