package prog_409_longestPalindrome.prog_525_maximumSubArray;

import java.util.HashMap;

public class Solution {
    /*
Running Sum Algorithm :

In an array, if we know the running sum between index 0 to x and index  0 to y then
Then sum between index x+1 and y would b z = y- x
[1,2,3,4,5,6,7]
[1,3,6,10,15,21,28]
Here from 1 -> 2 = 3
And 1 -> 5 = 15
So running sum from 3 -> 5 = 15 - 3 (12)

In this program, we have given an array with 0 and 1, and we have to find of balanced contiguous sub array in the same order.
We have to return the maximum legth of the subarrays

Brut Force:
Nested Iteration approach

[1, 0, 1, 0, 1, 1, 0, 0 , 1, 1, 1]
In this approach firstly, we will b start with index 0 and we form subaaray with every index of i+1
{[1,0], [1, 0, 1], [1, 0,1, 0], [1,0 ,1, 0, 1].........
[0,1], [0, 1, 0]..............
}
Once we form all the sub arrays, we will iterate through it, we will return the length of the sub array with the maximum.
Time Complexity: O(n2)


Running Sum Algorithm:

Here we will be maintaining the running sum of the array. If its 1 then increase by 1, if its 0 then decrese by 1
index  0, 1, 2, 3, 4, 5, 6, 7,  8,  9, 10
Array  [1, 0, 1, 0, 1, 1, 0, 0 , 1, 1, 1]
RS.    [1. 0. 1. 0. .........]
MaxLength  = 0 (Current index - Earliest Index happen before)
   RM : Earliest Index happen before
{ {1  : 0}
  {0. : 1}
}

Here, we are not able to handle the edge case, [1, 0 ] is balanced, in order to handle it we will be adding 0 at -1 index as a dummy index.
  RM : Earliest Index happen before
{ {0  : -1}
  {1  : 0}
}
We will be starting with index 1 now, If 0 happen before ? Yes at index -1
so maxlength = 1 - (-1) = 2

Next index 2, If 1 happen before? Yes at index 0
max = 2 - (0) = 2

Next index 3, If 0 happen before? yest at index -1
max = 3 - (-1) = 4
.
.
.
.
At the end we will be returning max sub array value which is 8 here(Index 0, 7  & 1, 8)

Time Complexity : O(N)
Space Complexity : O(N) its N and not 1 becoz we can have all the 0's or 1's in the array
so we have to store different RM in the map.

if Array [0 , 0 ,1, 1]
          -1 -2  -1 0. In this case we will be starting from -1 and not 0
*/

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        int maxLengthSubArr = 0;
        storage.put(0, -1);
        int runningSum = 0 ;
        for(int i=0; i <= nums.length -1 ; i++){
            int num = nums[i];
            if(num == 0){
                runningSum = runningSum - 1 ;
            }
            else{
                runningSum = runningSum + 1 ;
            }
            if(!storage.containsKey(runningSum)){
                storage.put(runningSum, i);
            }
            else{
                int earliIndex = storage.get(runningSum) ;
                int max = i - earliIndex ;
                if(max >= maxLengthSubArr){
                    maxLengthSubArr = max ;
                }
            }


        }
        return maxLengthSubArr ;
    }
}