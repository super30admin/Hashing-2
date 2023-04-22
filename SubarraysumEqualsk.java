import java.util.HashMap;

// Time Complexity : O(n^3) n is length of nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: BRUTE FORCE
/*
 * In a brute force way, we calculate the sum of all possible combinations and if equals k we add 1 to count.
 */
public class SubarraysumEqualsk {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= nums.length; j++) {
                int sum = 0;
                for(int a = i;  a < j; a++) {
                    sum += nums[a];
                }
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Time Complexity : O(n) n is length of nums
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We use running sum approach and hashmap where key is rSum and value is frequency of rSum
 * we check if our map has key = rSum -  k, which means we have already seen k and add it to total
 * else put current rsum in map. 
 */

class SubarraysumEqualskMap {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int total = 0;
        int rSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            if(map.containsKey(rSum - k)) {
                total += map.get(rSum - k);
            }
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
        }
        return total;
    }
}
