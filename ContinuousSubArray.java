/**
-->Brute Force : Create sub arrays with nested iteration and check if the sub array is balanced and return the maxLength. Time :n2.
-->Optimal: In order to remove nested iteration we can use running sum pattern. If I know runnig sum till ith index(call it x) and running sum till i+7 call it y then in order to find running sum between i and i+7(call it z). z = y-x
Eg. If know rsum till index 5, and till index 2, then I can calculate rsum from index 3 to 5. which is rsumof5-rsumof2.
->For each zero decrese rsum by 1. for each 1 increse rsum by 1
-->If rsum of 2 indices are same, array between those 2 indices is balanced.
*/

//Time Complexity :O(N)-> N  total numbers length
// Space Complexity : O(N)

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class ContinuousSubArray {
    public int findMaxLength(int[] nums) {
        int rSum = 0;
        int maxLength = 0;
        //rsum, earliest index where this rSum occured
        Map<Integer, Integer> map = new HashMap<>();
        //For the edge case (0,1) say 0 rSum has occured at index -1
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rSum--;

            } else {
                rSum++;
            }
            //if map doesnt conatin rSum , add it to the map with rSum and current index
            if (!map.containsKey(rSum)) {
                map.put(rSum, i);
            } else {
                // if two indices has same rSum array between them is balanced
                maxLength = Math.max(maxLength, i - map.get(rSum));
            }
        }
        return maxLength;
    }
}