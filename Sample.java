// Time Complexity :O()
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


// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I don't properly understand this problem

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        
        int maximumLength = 0;
        int count = 0;
        
        //loops through the array linearly and increment the counter if it is 1 and decrement the counter if it is zero.
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count += -1;
            }
            else{
                count += 1;
            }
            
            if(map.containsKey(count)) {//checks if we have see the count before and if we have,
                maximumLength = Math.max(maximumLength, i-map.get(count)); //we check against the max
            }
            else{
                map.put(count, i);
            }
        }
        return maximumLength;//The return the maximum length of the sub-array.
        
    }
}


// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I don't properly understand this problem
class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128]; //An array that keeps count of the number of occurrencies of a character
        for(char c : s.toCharArray()){//Loop through all the characters in the string
            charCount[c]++; //Access the index of the string by passing in c which is the character that would be converted to the ASCII index in this array.
        }
        
        int result = 0 //Initialize the result 
        for(Integer characterCount: charCount) {//Loop through each integer in the character count array.
            result += characterCount / 2 * 2; //This integer division adds on any pair of integer that is divisible by 2
            if(result % 2 == 0 && characterCount % 2 == 1){
                result += 1;
            }
        }
        return result;
    }
}