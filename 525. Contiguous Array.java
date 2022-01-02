// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we maintain the running sum in a hashmap with running sum as a key and index as value as we want the longest subarray
//so we would use this inex to get length where we find already enered rSum key
//because if we have r sum equal in a bonary array that means the subarray is balanced as we subtract anmd add 1 for each
//0 and 1 occurence
//we start with key 0 and value -1 aw we dont want to miss first element

class Solution {
    public int findMaxLength(int[] nums) {
        int max=0;
        int rSum= 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                rSum--;
            }else{
                rSum++;
            }
            if(map.containsKey(rSum)){
               max = Math.max(max, i- map.get(rSum));
            }else{  
                map.put(rSum, i);
            } 
        }
        return max;
    }
}