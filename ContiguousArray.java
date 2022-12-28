// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We traverse the array and keep track of the running sum in a variable
// We use another hashmap to keep track of the running sum->index mapping
// While traversing we update running sum and max length

class Solution {
    public int findMaxLength(int[] nums) {
        int max=0, rSum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); //edge case when nums[0] is part of the contiguous array
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                rSum+=-1;
            else
                rSum+=1;
            if(!map.containsKey(rSum))
                map.put(rSum,i);
            max = Math.max(i-map.get(rSum), max);
        }
        return max;
    }
}