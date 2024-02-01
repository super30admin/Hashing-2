import java.util.HashMap;

//Running Sum Pattern
//Use a HashMap to store the running sum and its number of rSum occurances while iterating through the int array
//When a rSum-k is present in the map as key after reducing the target sum K
//By checking the map for each new running sum calculated minus k, it gives you a subarray with sum equals k 
//so increment count by value stored in map


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
public class Problem1_SubarraySumEqualsK{
    public int subarraySum(int[] nums, int k) {
        if(nums==null) return 0;
        int n=nums.length, rSum=0, count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n; i++){
            rSum+=nums[i];
            if(map.containsKey(rSum-k)){
                count+=map.get(rSum-k);
            }
            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }
        return count;
    }
}