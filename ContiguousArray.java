// Time Complexity : O(n).
// Space Complexity : O(n) - worst case
// Did this code successfully run on Leetcode : Yes
// Approach : We will have a running counter which increases by 1 if it encounters a 1 else decreases by 1 if it encounters 0. The same counter values between
// two indexes will give the largest contiguous subarray. So, I am storing the counters along with it's index in hashmap and performing the logic when same
// counter value is encountered while parsing the array.

// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int output = 0;
        int counter = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                counter -= 1;
            }else{
                counter += 1;
            }
            if(map.containsKey(counter)){
                int length = i - map.get(counter);//length calculation when same counter is encountered
                output = Math.max(output,length);
            }else{
                map.put(counter, i);//put in the map if it's new counter value
            }
        }
        return output;
    }
}