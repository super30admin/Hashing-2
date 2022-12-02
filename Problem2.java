// Time Complexity : O(nums.length) 
// Space Complexity : O(nums.length)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : The technique for initializing the map with 0 was a bit hard

// we will iterate over the array, calculate the running sum and check if that sum was envountered already, if so we would know the max length
//otherwise we would add it to the hashmap
class Solution {
    public int findMaxLength(int[] nums) {

        int maxCount = 0;

        // Hashmap would contain the running sum and its index

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1); // initializing 0 at -1 index
        int sum =0;

        for(int i=0;i<nums.length;i++){
            // if we encounter zero we would decrement the sum, if we encounter 1, we would increment 
            if(nums[i] == 0){
                sum-=1;
            }
            else{
                sum+=1;
            }

            // have we seen it before ?, if so the diff of indeces would be the length of the subarray

            if(map.containsKey(sum)){
                int prevIndex = map.get(sum);
                int diff = i - prevIndex;
                if(diff > maxCount){
                    maxCount = diff; // if this subarray is longer, then record its length
                }
            }
            else{
                map.put((Integer)sum,(Integer)i); // only put it if not found previously, as we are only maintaining starting indices
            }

            // The reason we are not updating the index when we found the sum again is that we want to take max of the subarray
            // if we update it with the new index, then we would not be able to find the longest one

        }
        return maxCount;

        
    }
}