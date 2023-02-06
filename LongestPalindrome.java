/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Approach : For this question we first create a hashset. For every character of the given string we check if it's already present in the set. If yes, then
 * we have found 2 same characters, hence we pop the character and increase count by 2. At the end if there are some elements present in the hashset we increase the count by 1.
 */


//https://leetcode.com/problems/longest-palindrome/description/
class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> mySet = new HashSet<>();
        int count = 0;
        for (int i=0;i<s.length();i++){
            if(mySet.contains(s.charAt(i))){
                count+=2;
                mySet.remove(s.charAt(i));
            }else{
                mySet.add(s.charAt(i));
            }
        }
        if(!mySet.isEmpty())return count+1;
        return count;
    }
}