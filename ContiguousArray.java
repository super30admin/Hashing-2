// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We keep a running sum and a result (for the length of the array) starting at 0.
// We traverse through the array and do rSum-- when we encounter a 0, or rSum++ when we encounter a 1.
// We keep a hashmap and at every iteration we check if the current rSum is present, if not we add it.
// If present, then we need to find the maximum distance between rSum's previous index and the current index at which same rSum occured.
// Return the max distance in the result variable


class Solution {
    public int findMaxLength(int[] nums) {
        int result=0;
        int rSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int start=0;int end=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                rSum--;
            } else{
                rSum++;
            }
            if(!map.containsKey(rSum)){
                map.put(rSum,i);
            } else {
                //rsum exists, so index-the index where rSum occured before
                result=Math.max(result,i-map.get(rSum)); 
                start=map.get(rSum)+1;
                end=i;
            }
        }
        System.out.println(start);
        System.out.println(end);
        return result;
        
    }
}