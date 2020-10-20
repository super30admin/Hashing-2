//This problem was asked at Amazon
//
//        LeetCode: 525
//
//        Current Statement
//
//        Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//
//        Example 1:
//
//        Input: [0,1]
//
//        Output: 2
//
//        Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer,Integer> count = new HashMap();
        count.put(0,-1);

        int max_length = 0;
        int counter = 0;

        for(for int i=0;i<nums.length;i++){
            if(nums[i]==0){
                counter += -1;
            }
            esle{
                counter += 1;
            }

            if(count.containsKey(counter)){
                max_length = Math.max(max_length, i-count.get(counter));
            }
            else{
                count.put(counter,i);
            }
        }

        return max_length;
    }
}