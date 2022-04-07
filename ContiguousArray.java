import java.util.HashMap;
import java.util.Map;

// Time complexity: O(n)
// Space complexity: O(1)
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int count = 0;
        int max = 0;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // this will handle [1,0] or [0,1]
        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 1) count += 1;
            else count -= 1;

            // Put the count value in a map
            // key -> count value -> index at which we saw this count value
            if(map.containsKey(count)) max = Math.max(max, i - map.get(count));

            // If the count value doesn't exist in the map then only put it in the map
            else map.put(count,i);
        }

        return max;
    }
}
