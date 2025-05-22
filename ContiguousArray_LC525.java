/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Approach -
-calculate prefixSum - when we encounter 1 increase runingSum and when 0 decrese it.
-Maintain Hashmap with index and prefixsum(runningsum of previous indexes)
-if the same prefixSumFound, take the differnece if stored index and current index and compare it with global max
- retain max as well as keep in mind we have to always store earliest index so that we can get max length of contiguous array

e.g for this array    [0,1,1,1,1,1,0,0,0]
the running Sum will be  0 1 2 3 4 5 4 3 2

hashmap will be {sum, index}
                {0-0}
                {1-1}
                {2-2}
                {3-3}
                {4-4}
                {5-5}
                when we encount another 4 as a runing sum we can simply say that the earlier same sum and till this sum we will have balance array of 0 and 1 so when we get 4 as a running Sum in from our hashmap we will fetch the index of prefixSum which is 4 and current index which is 6 so 6-4 is 2 which is by far max length, likewise we keep iterating an array and at last index we have running sum as 2 and same sum xist in the map too, so that index is 2 and last index is 8 which gives us the max index so far and this ends our array iteration so we return 6 as an answer.

Edge case1 : if the contiguous subarray is starting from 0 index itselt the above logic will fail
for e.g [1, 0, 0 ,1] for this array our hashmap will be {1-0} {0- 1}
{0, -1}dummy
{1, 0}
{0 ,1} 1- (-1) = 2 max
{-1, 2}
{0, 3}  3- (-1) = 4 max

Edge case 2 : [0 1 0 1]
so adding a dummy {0, -1} will resolve this issue where 0 is sum and index is -1
Edge case 3: [0, 0,1]

note if 0 is startinf from 0th index we have to do 0-1 which is -1

Time complexity : O(N) for iterating an array and  + O(1) for checking it against hashmap ~ O(N)
Space Complexity : O(N) for map ~ O(N)

*/

import java.util.HashMap;

public class ContiguousArray_LC525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 0 sum for -1 index to capture edge cases
        int prefixSum = 0;
        int maxLen =0;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == 0){
                prefixSum -= 1;
            } else {
                prefixSum+=1;
            }
            if(map.containsKey(prefixSum)){
                int index = map.get(prefixSum);
                maxLen = Math.max(maxLen, i -index);
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}