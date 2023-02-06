/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Approach : In this we consider a hashmap and running sum where in each time we encounter a 1 we increment rsum by 1 and for 0 we decrement rsum by 1. 
 * We check if the current rsum value already exists in the map. If yes we check if current index - intial index of rSum is max. If Rsum doesn't exists we 
 * push in the rSum and the current index into the map.
 */


//https://leetcode.com/problems/contiguous-array/description/

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rsum = 0;
        int max = 0;
        map.put(0,-1);
        for (int i=0;i<nums.length;i++){
            if(nums[i]==1){
                rsum++;
            }else{
                rsum--;
            }
            if(map.containsKey(rsum)){
                max=Math.max(i-map.get(rsum),max);
            }else{
                map.put(rsum,i);
            }
        }
        return max;
    }
}