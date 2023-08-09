// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int rSum=0; // using running sum
        map.put(0,-1);// dummy input to indulde the starting index also
        int max=0;

        for (int i=0; i<nums.length;i++){
            if(nums[i]==0) rSum--;
            else rSum++;
            if(map.containsKey(rSum)){
                max=Math.max(max,i-map.get(rSum)); //finding max length using index's
            }
            else{
                map.put(rSum,i); // adding to map only inital values
            }
        }
        return max;
    }
}
    
