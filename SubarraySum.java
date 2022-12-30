import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we use a hashmap to store the running sum as key and the count of that sum as the value. If the complement is 
//present than we increment the count by the value of that complement. If the rsum is not present we add it to the map. If it is present
//we update the count. and finally return the count. 
public class SubarraySum {
    
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length== 0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int rSum =0;
        map.put(0,1);
        int count = 0;

        for(int i=0;i<nums.length;i++){
            rSum += nums[i];
            if(map.containsKey(rSum-k)) count += map.get(rSum - k);
            if(!map.containsKey(rSum)){
                    map.put(rSum,1);
            }else{
                // count += map.get(rSum);
                map.put(rSum,map.get(rSum)+1);
            }
        }
        return count;
    }
    
}
