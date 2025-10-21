import java.util.HashMap;
import java.util.Map;
/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // running sum vs occurances
        map.put(0, 1);
        int runningSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum = runningSum + nums[i];

            int complement = runningSum - k;
            if(map.containsKey(complement)) {
                count = count + map.get(complement);
            }
            
            if(!map.containsKey(runningSum)) {
                map.put(runningSum, 1);
            } else{
                map.put(runningSum, map.get(runningSum) + 1);
            }
          
        }

        return count;
    }

    public static void main(String[] args) {
        int i = new SubArraySum().subarraySum(new int[]{2,5,6,4,3,6,7,8,9,-1,-4,-5,-11}, 3);
        System.out.println(i);
    }
}