import java.util.HashMap;
import java.util.Map;

//time: O(n)
//space: O(n)
public class Problem2 {
    static int findMaxLength(int[] nums) {
        Map<Integer, Integer> lastOccMap = new HashMap<>();
        int rcount = 0;
        int result = 0;
        lastOccMap.put(0,-1);
        for (int i=0;i<nums.length;i++) {
           rcount =  (nums[i] == 1)?rcount+1:rcount-1;
            if (!lastOccMap.containsKey(rcount)) {
                lastOccMap.put(rcount, i);
            }
            else {
                result = Math.max(i - lastOccMap.get(rcount), result);
            }

        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println("max length "+findMaxLength(new int[]{0,1,1,0,1,1,1,0}));
    }
}