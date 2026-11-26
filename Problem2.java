// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach: We maintain running sum and store it in HashMap
// if we encounter 1 we increment rSum by 1 else we decrement by 1
// we keep the Key as rSum and value as index and if we encounter the same rSum
// we calculate the difference b/w the current index and the first index of occurance
// we keep a length for the occurance and return the max.

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = 0;
        int rSum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum = rSum - 1;
            }else{
                rSum = rSum + 1;
            }
            if(map.containsKey(rSum)){
                length = Math.max(length, i - map.get(rSum));
            }else{
                map.put(rSum, i);
            }
        }
        return length;
    }
}