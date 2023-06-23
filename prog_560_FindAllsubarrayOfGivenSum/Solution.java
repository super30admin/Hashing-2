package prog_560_FindAllsubarrayOfGivenSum;

import java.util.HashMap;

public class Solution {
/*
This is Running Sum problem.

In an array, if we know the running sum between index 0 to x and index  0 to y then
Then sum between index x+1 and y would b z = y- x
[1,2,3,4,5,6,7]
[1,3,6,10,15,21,28]
Here from 1 -> 2 = 3
And 1 -> 5 = 15
So running sum from 3 -> 5 = 15 - 3 (12)

Approach:
In this approach we will be taking the running sum of the array value.
In hashmap we will be storing Running Sum and its frequency which means how many times runningSum has occured before.
We will be calculating difference = Running Sum - target
1) If my difference is already exist in the HashMap,
   then we will simply take the frequency and increase the total count
2) Now we will put Running Sum in hashmap. We will check if running sum is already in hashmap
    If yes then we will increase the existing frequency of runningSum by 1
    else, We will put the frequency as 1

To handle the edge case, we have added the Sum 0,1 which means 0 has occured 1 time.
Remember, in hashmap we will be storing Running Sum and not the difference. We should increase total count first and then put it into map.

Time Complexity : O(N)
Space Complexity : O(N)

 */

    public int subarraySum(int[] nums, int k) {
        int totalCount = 0 ;
        HashMap<Integer, Integer> storage = new HashMap<>();
        int runningSum = 0;
        storage.put(0,1);
        for(int i=0; i< nums.length  ; i++){
            runningSum = runningSum + nums[i] ;
            int diff = runningSum - k ;

            if(storage.containsKey(diff)){
                totalCount = totalCount + storage.get(diff) ;
            }

            if(storage.containsKey(runningSum)){
                int newCount = storage.get(runningSum) ;
                newCount= newCount+1 ;
                storage.put(runningSum, newCount);
            }
            else{
                storage.put(runningSum, 1);
            }

        }
        return totalCount ;
    }
}

