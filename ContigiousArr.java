// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I am using a Hashmap to keep track of the running sum values
// if the value at i is 0, rSum is decreased by 1 otherwise it is is increased.
// Then I check the map to see if the rSum value has already been added, if not
// I add it with i as the value to keep track of the first instance. Otherwise
// I get the max between my current max length or i minus the index of rSum's first
// occurence.
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rSum = 0; //to keep track of the Running sum
        int max = 0;
        map.put(0, -1); //dummy val
        //calculate the running sum
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum -= 1;
            }
            else{
                rSum += 1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else{
                map.put(rSum, i);
            }
        }
        return max;

    }
}