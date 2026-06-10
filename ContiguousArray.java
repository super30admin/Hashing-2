import java.util.HashMap;

class Solution {
    /*
        TC - O(n)
        SC - O(n)
        Solution - Go through the array and record the running sum (when we see 1, incr count else 
        decr count) and the first index we get the running sum in the map. If the running sum already exists, 
        calculate the difference between the current index and the index from map and record it if greater than max length. 
        The idea is that if running sum at two indexes are same, the array has equal number of 1's and 0's.
    */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int runningSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //to handle edge case where array is completely balanced

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                runningSum++;
            } else {
                runningSum--;
            }

            if (map.containsKey(runningSum)) {
                maxLength = Math.max(maxLength, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }

        return maxLength;
    }
}