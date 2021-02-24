class Solution {
    public int findMaxLength(int[] nums) {
        // Initializing currSum and maxLt to 0.
        int currSum = 0;
        int maxLt = 0;
        // Initializing hashmap, we are storing currSum and start index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // Iterate through nums array, we are taking 0 as +1 and 1 as -1. We add the +1 and -1 to currSum as we iterate forward
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                currSum += 1;
            }else{
                currSum -= 1;
            }
            // When map has no key of currSum, we put it in map with currSum and index
            if(!map.containsKey(currSum)){
                map.put(currSum, i);
            // When map has a key of currSum, we are sure that there are equal number of 0's and 1's, as we are reaching to the same sum.If yes,             // maxLt would be max of maxLt and difference between value of currSum in map
            }else{
                maxLt = Math.max(maxLt, i - map.get(currSum));
            }
        }
        // return the maxLt
        return maxLt;
    }
}