// Contiguous Subarray

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to go through the class recording about running sum a few times
// Your code here along with comments explaining your approach: 
//To calculate running sum, whenever we encounter a '0' we decrement by 1 and when we encounter a '1' we increment.
//We maintain a hashmap with keys as distinct running sums and values as the index of their earliest occurence
//We keep a max counter to keep track of the max subarray found. We check if the running sum already exists in the hashmap, 
//if it does then we check the difference between the current index and the earliest found index(value) and update the value of max.Eventually we return max


import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {



        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0,Rsum=0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++)
        {
            //calculate the running sum

            if(nums[i]==1)
            {
                Rsum++;
            }
            else
            {
                Rsum--;
            }

            //check if the Rsum already exits in the Hashmap
            if(map.containsKey(Rsum))
            {
                max=Math.max(max,(i-map.get(Rsum)));
            }
            else
            {
                map.put(Rsum,i);
            }
        }

return max;
    }
}
