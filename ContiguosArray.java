import java.util.HashMap;

// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach: BRUTE FORCE
/*
 * For each index, we iterate over the entire array to find the equal number of 0s and 1s and update max
 * We compare with previous max and update it accordingly
 * and return max length
 */
public class ContiguosArray {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if(count0 == count1) {
                    max = Math.max(max, count0+count1);
                }
            }
        }
        return max;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
 

// Your code here along with comments explaining your approach: 
/*
 * We use running sum approach and hashmap where rSum is the key and index being value,  
 * we add default entry in map for {0, -1} to cover case where array is [0,1]. We subtract 1 from rSum if value is 0,
 * else add 1. and update max accordingly. 
*/

class ContiguosArrayMap {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            rSum = (nums[i] == 0) ? rSum - 1 : rSum + 1;
            if(map.containsKey(rSum)) {
                int index = map.get(rSum);
                max = Math.max(max, i - index);
            } else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}


