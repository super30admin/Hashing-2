import java.util.HashMap;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int numberOfSubArrays = 0;
        int updatedValue = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        if(nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                numberOfSubArrays += map.getOrDefault(sum - k, 0);
            }
            updatedValue = map.getOrDefault(sum, 0) + 1;
            map.put(sum, updatedValue);
            
        }
        return numberOfSubArrays;
    }
}
