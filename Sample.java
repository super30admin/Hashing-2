//Problem 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The general idea behind this solution is to keep track of the running sum of the
// array. This allows us to calculate if the number of ones and zeros in a particular
// subarray are equal without having to do a linear search on that particular array.
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int rs = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            rs += nums[i];
            int complement = rs-k;
            if(hm.containsKey(complement)){
                count += hm.get(complement);

            }
            if(hm.containsKey(rs)){
                hm.put(rs,hm.get(rs)+1);
            }
            else{
                hm.put(rs,1);
            }
        }
        return count;
    }
}




//Problem 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The general idea behind this solution is to keep track of the running sum of the
// array. This allows us to calculate if there exists a subarray where the sum equals
// k. The key point is to calculate the compliment, so that we can see if there exists
// a value in the hashmap that we can use to add up to the sum.
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int rs = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                rs--;
            }
            if(nums[i] == 1){
                rs++;
            }
            if(hm.containsKey(rs)){
                max = Math.max(max,i-hm.get(rs));
            }
            else{
                hm.put(rs,i);
            }
        }
        return max;
    }
}





//Problem 3
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//The general idea behind this solution is that we can add the characters into a set
//if they don't appear, or increment our count by 2 if the character already exists and
//then remove it. In the end, if the set is not empty, add 1 to account for having one
// character in the center of the possible palindrome. 
class Solution {
    public int longestPalindrome(String s) {
        HashSet <Character> set = new HashSet<>();
       int count = 0;
       for(int i = 0; i < s.length(); i++){
           char c =  s.charAt(i);
           if(set.contains(c)){
               set.remove(c);
               count += 2;
           } else {
               set.add(c);
           }
       }
       if(!set.isEmpty())return count+1;
       return count;
    }
}