import java.util.HashMap;

public class ContiguousArray {
    //TC:O(N) SC:O(N)
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int runningSum = 0;
        HashMap<Integer, Integer> mapper = new HashMap<>();
        mapper.put(0, -1); // in include initial 0, 1 
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) runningSum++;
            else runningSum--;
            if(mapper.containsKey(runningSum)) {
                int earlierIndex = mapper.get(runningSum);
                maxLength = Math.max(maxLength, (i - earlierIndex));
            } else mapper.put(runningSum, i);
        }
        return maxLength;
    }
}