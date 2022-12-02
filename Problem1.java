// Time Complexity : O(nums.length) 
// Space Complexity : O(nums.length)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : The technique for initializing the map with 0 was a bit hard


// Your code here along with comments explaining your approach
/*
Running sum technique: keeping a running sum as we encounter elements in the array, we can take difference of the that sum with k and see if it happened earlier in our hashmap , if so , we will increase the count by that number
Important, add 0 mapped 1 , in the hashmap
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // initialize
        map.put(0,1); // initialize 0 , as its requirement of the running sum pattern

        int count =0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int diff = sum - k;

            // check if that diff happened before, if so increase the count by that number
            if(map.containsKey(diff)){
                count+= map.get(diff);
            }
        map.put(sum,map.getOrDefault(sum,0) +1); // we will increase the count of sum if it was seen already
        
        }  

        return  count;
    }
}