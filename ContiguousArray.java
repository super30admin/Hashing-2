import java.util.HashMap;

// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //Initial Marker
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0)
                rSum--;
            else
                rSum++;
            if(map.containsKey(rSum)){
                max = Math.max(max,i-map.get(rSum)); // i-map.get gives the length from first occurance of that sum
            }
            else
                map.put(rSum, i);
        }
        return max;
    }
}
