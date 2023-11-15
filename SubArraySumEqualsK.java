import java.util.HashMap;

// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int rSum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();//running sum, frequency
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            rSum += nums[i];
            if(map.containsKey(rSum-k))
                count+= map.get(rSum-k);   //Adding the frequency of previous occurances
            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }
        return count;
    }
    // len = Math.max(len, i- map.get(rSum-k));// this to give max length but here we need count
}
