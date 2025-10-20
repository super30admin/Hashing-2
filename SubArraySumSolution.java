/*
Time Complexity: O(n)
Space Complexity: O(n)

Approach:
1) Calculate the running sum of given array
2) Add the running sum(key) and its frequency(value) to a HashMap by checking if runningSum-k exists in the array
3) If runningSum-k exists, then excluding the sub array with that runningSum is one of our desired sub array
4) Add the frequency at runningSum-k to a counter.
 */
import java.util.HashMap;
public class SubArraySumSolution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int rsum = 0;
        int subArrayCount = 0;
        // Add rSum as 0 and value as 1 to cover edge cases when the desired subarray starts at index 0 or with -ve values in array
        hashMap.put(0,1);
        for(int i: nums){
            // Calculating running sum
            rsum += i;
            // If runningSum - k is present
            if(hashMap.containsKey(rsum-k)){
                // Add frequency at runningSum-k to a counter
                subArrayCount+=hashMap.get(rsum-k);
            }
            // Add the running sum and it's frequency +1 if it already exists(in case of array with -ve values)
                 // or 1 incase this the 1st occurance of running sum.
            hashMap.put(rsum,hashMap.getOrDefault(rsum,0)+1);
        }
        return subArrayCount;

    }
}
