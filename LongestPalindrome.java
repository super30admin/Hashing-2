// Time Complexity : O(n) where 'n' is the length of the string.
// Space Complexity : O(1) because it is constant with 52 length with both upper and lower case
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/longest-palindrome/
// Any problem you faced while coding this : No

class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
               count +=2;
               set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count+=1;
        }

        return count;
    }
}
