//Problem: Longest Palindrome
//Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//Letters are case sensitive, for example, "Aa" is not considered a palindrome.
// Time Complexity : O(n), all hashmap operationd are average O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count =0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count = count +2;
                set.remove(ch);
            }
            else
            {
                set.add(ch);
            }

        }
        if(!set.isEmpty()){
            count ++;
        }

        return count;
    }
}