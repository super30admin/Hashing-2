/*this implementation uses Hashmap to find the max length
 * the time complexity for this implementation is O(n)*/
import java.util.*;
public class MaxLength {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int cumulativeDifference = 0;
        Map<Integer, Integer> cumulativeDiffMap = new HashMap<>();
        cumulativeDiffMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            cumulativeDifference += nums[i] == 0 ? -1 : 1;
            if (cumulativeDiffMap.containsKey(cumulativeDifference)) {
                maxLength = Math.max(maxLength, i - cumulativeDiffMap.get(cumulativeDifference));
            } else {
                cumulativeDiffMap.put(cumulativeDifference, i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args){
        int[] nums = {0,1,0};
        System.out.println(findMaxLength(nums));
    }
}
