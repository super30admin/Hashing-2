//Time Complexity : O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
**Brute force solution will be iterating through entire array to create subarrays and again checking if each subarray has sum equal to k.This takes O(n power3)
**Whenever we have multiple iterations, we can optimize using running sums method.
Iterate through array populating running sums map with rSum and frequency k,v pair during traversal. Get the (rSum - target) to check if the key already exists in map, if yes, increment the counter, else add to the map.
** Add initial entry (0,1) to handle edge condition
*/
class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        int rSum = 0;
        map.put(0,1);

        for(int i=0; i< nums.length; i++) {
            rSum += nums[i];
            if(map.containsKey(rSum-k))
                counter+=map.get(rSum-k);
            map.put(rSum, map.getOrDefault(rSum,0)+1);
        }
        return counter;
    }

    public static void main(String args[]) {
        int[] in = new int[]{1,3,4,7};
        int k = 7;
        int res = new SubArraySum().subarraySum(in, k);
        System.out.println("Count of sub arrays with sum " + k + " is " + res);

        in = new int[]{1,1,1,1};
        k = 2;
        res = new SubArraySum().subarraySum(in, k);
        System.out.println("Count of sub arrays with sum " + k + " is " + res);

        in = new int[]{1,2,3};
        k = 3;
        res = new SubArraySum().subarraySum(in, k);
        System.out.println("Count of sub arrays with sum " + k + " is " + res);

        in = new int[]{-1,1,0};
        k = 0;
        res = new SubArraySum().subarraySum(in, k);
        System.out.println("Count of sub arrays with sum " + k + " is " + res);

        in = new int[]{1};
        k = 1;
        res = new SubArraySum().subarraySum(in, k);
        System.out.println("Count of sub arrays with sum " + k + " is " + res);
    }
}