/*
 
Problem3 (https://leetcode.com/problems/longest-palindrome)

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Using runing sum along with hashmap to store the sum along with the count. Consider +1 for 1 and -1 for 0, store the rSum
along with index, if we find the same rSum again then we can find the diff from the first index.

*/


class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length();i++){
            
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count = count + 2;
            }

            else{
                set.add(s.charAt(i));
            }
        }

        if(!set.isEmpty()){
            return count+1;
        }

        return count;

    }
}