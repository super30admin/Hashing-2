// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int subarraySum(int[] nums, int k) {
         HashMap<Integer,Integer> map= new HashMap<>();
         int rsum=0;
         int counter=0;
         map.put(0,1);
         for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
            if(map.containsKey(rsum-k)){
                counter+=map.get(rsum-k);
            }
            map.put(rsum,map.getOrDefault(rsum,0)+1);
         }
     return counter;
    }
}

/* Used Pattern Running Sum (z=x-y)using Hashmap- 
For this first I summed all the values, and use to 
compare at the gaps of k if the number repeated, if it did then it 
indicated that it is forming a subarray with sum k and I used to update
the counter based on number of subarrays it is forming.  */
