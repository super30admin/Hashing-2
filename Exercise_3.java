// Longest Palindrome
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
// consider a Hashset (Boolean array of 26 char). Iterate over each char of the string.
// if the char is already present, a pair has found. So increase length by 2 and remove that char from the set.
// at the end will check the hashset is empty or not. If any remaining char left, will increase the length by 1.


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                //if already present increase the length & remove the occurance
                set.remove(c);
                count += 2;
            }
            else {
                set.add(c); //if a new char, add to set
            }
        }
        if(!set.isEmpty()) { //if not empty
            count++;
        }
        return count;
    }
}