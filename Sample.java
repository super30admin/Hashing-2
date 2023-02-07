// SUBARRAY SUM EQUALS K
//Space complexity : O(n) because HashMap will need to store all the different runningSum's
//Time complexity : O(n) where n is the length of string
//Approach : Using a HashMap to keep track of runningSum along with the number of times it occurs. If runningSum-k is found in the hashmap then corresponding count is added to result. If runningSum is not present in HashMap then add it too
class Solution {
    public int subarraySum(int[] nums, int k) {
         
         HashMap<Integer,Integer> myMap = new HashMap<>();
         myMap.put(0,1);
         int totalSubArray = 0;
         int runningSum = 0;
         int diff = 0;

         for(int i =0; i<nums.length;i++){

             runningSum+= nums[i];
             diff = runningSum - k;
             if(myMap.containsKey(diff)){
                 totalSubArray+=myMap.get(diff);
             }
             if(myMap.containsKey(runningSum)){
                 int newVal = myMap.get(runningSum)+1;
                 myMap.put(runningSum,newVal);
             }else{
             myMap.put(runningSum,1);
             }
         }
        return totalSubArray;
    }
}

//CONTIGUOS ARRAY
//Space complexity : O(n) because in worst case when all integers are o's or 1's then HashMap will need to store all the different runningSum's
//Time complexity : O(n) where n is the length of string
//Approach : Using a HashMap to keep track of runningSum along with the index at which it first occured. When same running sum occurs then substract the new index with the first index in hashmap to see the difference because this will give the longest contiguous subarray of 0 & 1 with equal numbers. Return the maxLength found. We introduce the dummy runningSum with index -1 to avoid a case like {1,0} which will return wrong length if dummy is not used
class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int runningSum = 0;
        HashMap<Integer,Integer> myMap = new HashMap<>();
        myMap.put(0,-1);
        for(int i =0; i<nums.length;i++){           
            if(nums[i]==0){
                runningSum--;
            }else {
                runningSum++;
            }
            if(myMap.containsKey(runningSum)){
                    int total = i-myMap.get(runningSum);
                if(maxLength<total) {maxLength = total;}
                }else{
                    myMap.put(runningSum,i);
            }
        }
        return maxLength;
    }
}

//LONGEST PALINDROME
//Space complexity : O(1) because at max 256 characters can be stored in set
//Time complexity : O(n) where n is the length of string
//Approach : Using a set to keep track of pair of characters. If a duplicate appears in the string while iterating, pop out from set and increase count by 2. In the end check if set is empty. If it is not empty then add 1 to count because one element can be in mid of palindrome string as well such as abcba
class Solution {
    public int longestPalindrome(String s) {

        int count = 0;
        HashSet<Character> mySet = new HashSet<>();

        for(int i =0; i< s.length();i++){
            char c = s.charAt(i);
            if(mySet.contains(c)){
                count+=2;
                mySet.remove(c);
            } else {
                mySet.add(c);
            }
        }
        if(!mySet.isEmpty()) count++;
        return count;
    }
}






