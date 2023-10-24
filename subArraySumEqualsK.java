import java.util.HashMap;

public class subArraySumEqualsK {

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this :No

    // Your code here along with comments explaining your approach
    // using the running sum pattern -> maintaining the cumulative sum and its
    // occurence

    public static void main(String[] args) {
        int count = 0, sum = 0;
        int nums[] = { 1, 1, 1 };
        int target = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target))
                count += map.get(sum - target);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
