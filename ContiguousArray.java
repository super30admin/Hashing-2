
import java.util.HashMap;
class ContiguousArray {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int runningSum = 0;

        int max = 0;

        map.put(0, -1);

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                runningSum -= 1;
            }

            else
            {
                runningSum += 1;
            }

            if(map.containsKey(runningSum))
            {
                max = Math.max(max, i - map.get(runningSum));
            }

            else
            {
                map.put(runningSum, i);
            }

        }

        return max;

    }
}