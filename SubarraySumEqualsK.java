// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Approach: We use a rSum variable to keep a running sum by adding one element in each iteration.
// We use a hashmap to keep current rSum to count mapping
// Before that we first check if the complement is present i.e. rSum-target, if that is present, we remove 1 occurence from the
//hashmap and increment the count. Then we check of rSum's presence in Hashmap and increase its occurence.
// We finally return the count 


class Solution {
    public int subarraySum(int[] nums, int k){ 
        int rSum=0;int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //initialize hashmap
        for(int i=0;i<nums.length;i++){
            rSum+=nums[i]; //add number to running sum
        
            // first you check if complement is present in map ...
            if(map.containsKey(rSum-k)){ //if map contains rsum - target (complement)
               count+=map.get(rSum-k); //increment count by getting occurence of complement from map
            }
            
            //... only then we add the rsum
            if(map.containsKey(rSum)){
               map.put(rSum,map.get(rSum)+1);
           } else {
               map.put(rSum,1);
           }
            
           
    }

    return count;
    
    }
}