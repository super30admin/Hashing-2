// Time Complexity : O(n)
// Space Complexity : O(n) for the HashMap
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach: I used a HashMap to store the frequency of cumulative sums. The key is the cumulative sum and the value is the frequency of that sum.
// The logic is that if the map contains currSum-k, this means there was a subarray that sums to this, if we remove all the elements before, the subarray from that point to current point will sum to k.

import java.util.HashMap;
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumsFreq = new HashMap<>();
        int currSum = 0;
        int res = 0;
        for(int n : nums){
            currSum += n;
            if(currSum==k) res++;
            if(sumsFreq.containsKey(currSum-k)) res+=sumsFreq.get(currSum-k);
            sumsFreq.put(currSum, sumsFreq.getOrDefault(currSum,0)+1);
        }
        return res;
    }
}