// Time Complexity :
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I don't properly understand this problem


// Your code here along with comments explaining your approach
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int result = 0;
        
        HashMap<Integer, Integer>map = new HashMap();//The first integer is the number of cumulative sum while the second Integer is the number of times we have seen that sum because they can been seen multiple times. 
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){//Loops through the array of numbers.
            result += nums[i];
            if(map.containsKey(result-k)) {
                count += map.get(result-k);   
            }
            map.put(result, map.getOrDefault(result, 0) + 1);//If its the first time we see the number, it will default to zero and we would add one to the hashmap and one to the sum. If it's not we would get the number of times we have seen it.
        }
        return count;
    }
}

