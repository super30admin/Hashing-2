// Time Complexity: O(n)
// Space Complexity: O(n)
//
// Approach:
// 1) Calculate the running sum
// 2) If a running sum value is reoccurred that subarray is balanced
// 3) Longest matching running sums is the desired longest subarray

import java.util.HashMap;

public class ContiguousArrayFinder {
    public int findMaxLength(int[] nums) {
        int rsum = 0;
        int maxSubArray = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Assuming that the sum starts at index -1 with value 0
        hashMap.put(0,-1);
        for(int i=0; i<nums.length;i++){
            // subtract by 1 if value at index i is 0
            if(nums[i]==0) rsum--;
            // add by 1 if value is 1
            else rsum++;
            // If a running sum already exists
            if(hashMap.containsKey(rsum)){
                // Check it longest balanced subarray till now
                maxSubArray = Math.max(maxSubArray,i-hashMap.get(rsum));
            }
            // Else add that running sum mentioning the 1st occurrence index as value
            else hashMap.put(rsum,i);

        }
        return maxSubArray;
    }
}
