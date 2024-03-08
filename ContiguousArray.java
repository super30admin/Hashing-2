// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class ContiguousArray {
    public int findMaxLength(int[] nums) {

        // TC: O(n)
        // SC: O(n)

        // here we will be using running sum
        // take 1 -> 1 and 0 -> -1
        // create a hashmap and keep a map of sum and its index

        // edge case would be [1,0,1,0], our logic will give us 2 but expected is 4
        // consider sum is 0 at index -1

        // null check
        // if(nums == null || nums.length == 0) return 0;
        //      sum, index
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);  //for edge case

        // running sum array
        // int[] runningSum = new int[nums.length];
        int runningSum = 0;
        int length = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                runningSum--; // consider 0 as -1
            } else {
                runningSum++;
            }

            if(sumMap.containsKey(runningSum)) {
                // get the index
                length = Math.max(length, i - sumMap.get(runningSum));
            } else {
                sumMap.put(runningSum, i);
            }
        }
        return length;
    }
}