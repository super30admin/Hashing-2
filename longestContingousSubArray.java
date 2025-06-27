// Time Complexity : O(n)
// Space Complexity : O(n) since we are storing the running sum in hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
    //coming up with this intituion was challenging. 
    //I was intially thinking to solve this problem with two pointers but prefix sum solution would be more efficient.


// Your code here along with comments explaining your approach

class Solution {
    public int findMaxLength(int[] nums) {

        //initution to solve this problem is to use a running sum
        //we take a starting value : 0 or any value 
        //for each encounter of 0 subtract 1 for each encounter of 1 add 1.
        //for each index we store this running sum into a hashmap
        //key will be sum and value will be the index

        //before adding to the hashmap, we check if the key is already present, 
        //if so we subtract the current index and index returned from my map for the key = running_sum
        //update max if this subtracted value is greater, 
        //meaning that so far it is count of elements of longest contiguous subarray.

        //base case
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        int running_sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        //edge case
        map.put(0 , -1);

        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == 0){
                running_sum = running_sum - 1;
                if(map.containsKey(running_sum)){
                    int recordedIndex = map.get(running_sum);
                    max = Math.max(max, (i - recordedIndex));
                }
                else{
                    map.put(running_sum, i);
                }
            }

            if(nums[i] == 1){
                running_sum = running_sum + 1;
                if(map.containsKey(running_sum)){
                    int recordedIndex = map.get(running_sum);
                    max = Math.max(max, (i - recordedIndex));
                }
                else{
                    map.put(running_sum, i);
                }
            }

        }

        return max;

    }
}