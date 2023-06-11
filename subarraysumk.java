// Time Complexity : O(n)
// Space Complexity : O(n)  //hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : while iterating through the array we calculate the running sum.
// if we find the rsum-k in the hash map then we add the frequency to the max (which is the count). If the hashmap contains rsum we need t
// increment the frequency by 1 else we need to add the rsum with frequency 1.

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int rsum=0;
        int max=0;
        HashMap<Integer,Integer> hmap= new HashMap<>();
        hmap.put(0,1);
        for(int i=0;i<n;i++)
        {
           rsum+= nums[i];
           if(hmap.containsKey(rsum-k)){
             max= max+ hmap.get(rsum-k);
             
           }
           if(hmap.containsKey(rsum)){
               hmap.put(rsum,hmap.get(rsum)+1);
           }else {
               hmap.put(rsum,1);
           }
        }
    return max;
    }
}