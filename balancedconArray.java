// Time Complexity : O(n)
// Space Complexity : O(n)  //hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understanding (0,-1)


// Your code here along with comments explaining your approach : while iterating through the array we calculate the running sum.
// if we get a 1 we increment by 1 and if we get 0 we decrement the rsum by 1. if rsum is repeating that means the subarray is balanced.
// so we update the max by subtracting the current index with the previous index where we have the same rsum.

// we added (0,1) this will be skipped as the hmap contains 0-0, 1-1 . we are subtracting index i-(previurs index). If we add 0 at -1
// when we get the 0 the rsum is -1 so we add to the hashmap. when we get the 1, the rsum is 0. so 1-(-1) =2.


class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int rsum=0;
        int max=0;
        HashMap<Integer,Integer> hmap= new HashMap<>();
        hmap.put(0,-1);
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1){
                rsum++;
            }
            else{
                rsum--;
            } 
            if(hmap.containsKey(rsum)){
                max = Math.max(max,i-hmap.get(rsum));
            } else {
                hmap.put(rsum,i);
            }
        }
    return max;
    }
}