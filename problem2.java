// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        int maxLength = 0, count=0;

        hashMap.put(0, -1);
        
        for(int i=0; i<nums.length; i++){

            count = count + (nums[i] == 1 ? 1 : -1);

            if(hashMap.containsKey(count)){
                maxLength = Math.max(maxLength, i-hashMap.get(count));
            } else {
                hashMap.put(count, i);
            }

        }
            
    return maxLength;
    }
}

