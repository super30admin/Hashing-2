// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashMap;

public class ContinousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, -1); // initially we have to put -1 dummy entry
        for(int i=0; i< nums.length; i++){
            if(nums[i]==0){
                sum = sum-1;
            }
            else {
                sum= sum+1;
            }
            if(map.containsKey(sum)){
                count = Math.max(count, i - map.get(sum));
            }
            else {
                map.put(sum, i); }
        }
        return count;
    }
}
