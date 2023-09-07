// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// https://leetcode.com/problems/subarray-sum-equals-k/description/


//
import java.util.*;

class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //hashmap will store runningSum, number of times the runningSum has occured
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        map.put(runningSum, 1);
        for(int i=0; i< nums.length; i++){
            runningSum+=nums[i];
            System.out.println("Sum at index i" + runningSum +i);
            if(map.containsKey(runningSum - k)){
                // System.out.println("inside map if" + map.get(sum-k));
                count += map.get(runningSum-k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
            //System.out.println("HashMap after iteration " + (i) + ": " + map);

        }
        return count;
        
    }

    public static void main(String args[]){
        SubArraySum subArray = new SubArraySum();

        int [] nums = {1,1,1};
        int k = 2;
        int result = subArray.subarraySum(nums, k);
        System.out.println("count of subarrays " + result);


    }
}