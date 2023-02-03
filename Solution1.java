import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * I use a hashmap to store the running sum and it's count. At first (0,1) is stored in the hashmap as running sum 0 has count 1. I then iterate through the array and calculate the running sum. 
 * If running sum - k is present in the map, I add count with the frequency of that running sum and then I update the count of running sum in the map. 
 */
class Solution1 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rSum=0,count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            rSum+=nums[i];
            if(map.containsKey(rSum-k))
            {
                count+=map.get(rSum-k);
            }
            map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
        return count;
    }
}