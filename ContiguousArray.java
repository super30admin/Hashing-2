// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After the class, now I understood this problem
class Solution {
    public int findMaxLength(int[] nums) {
        //Creating a HashMap
        Map<Integer, Integer> map = new HashMap<>();
        //Initializing maxlen and sum = 0
        int maxLen = 0, sum = 0;
        for(int i = 0; i< nums.length; i++){
            //if nums[i] is 0, then decrement sum by 1
            if(nums[i]==0){
                sum--;
            }
            //else increment sum by 1
            else{
                sum++;
            }
            // now if sum == 0, means we got the new contiguus array of len maxLen+1
            if(sum == 0){
                maxLen = i+1;
            }
            //if map doesn't contain the sum, then update map with sum and index
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            // else fetch the maxLen by comapring the maxlen and previous one
            else{
                maxLen = Math.max(maxLen,i - map.get(sum));
            }
        }
        return maxLen;
        
    }
}