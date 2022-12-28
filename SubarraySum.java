// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We traverse the array and keep track of the running sum in a variable
// We use another hashmap to keep track of the running sum->count mapping
// While traversing we update running sum and count

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        int rSum=0;
        map.put(0,1); //handles case when nums[0] is part of the subarray
        for(int i=0;i<nums.length;i++){
            rSum +=nums[i];
            if(map.containsKey(rSum-k))
                count=count+map.get(rSum-k);
            if(map.containsKey(rSum))
                map.put(rSum, map.get(rSum)+1);
            else
                map.put(rSum, 1);
        }
        return count;
    }
}