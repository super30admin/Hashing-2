// Time Complexity : O(n)
// Space Complexity : O(n) since we are storing the running sum in hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
    //none


// Your code here along with comments explaining your approach

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //we maintain a running sum for each element at index i
        //and add it to the hashmap with key the running sum and value as the number of times we saw it (frequency)
        //the idea is, if I have seen the running sum earlier then it must be computed by adding the target
        //so at each iteration we substract the target from the running sum 
        //and check if that value exists in our map, if it does then we update its count and add it to the total count.

        int running_sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        //base value
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++){

            running_sum = running_sum + nums[i];
            int diff = running_sum - k;

            if(map.containsKey(diff)){
                count = count + map.get(diff);
            }
            
            map.put(running_sum, map.getOrDefault(running_sum, 0) + 1);
        }
        return count;

    }
}