//Palindrome means there should be 2 same characters and one diff if odd.
//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                result+=2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if(!set.isEmpty()) result++;

        return result;
    }

}