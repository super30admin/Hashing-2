// Time Complexity: O(n), where n = length of the input string
// Space Complexity: O(1), since the HashSet can contain at most 52 characters (a-z, A-Z)
// Did this code successfully run on Leetcode? Yes
// Any problem you faced while coding this? No

// Approach:
// We use a HashSet to track characters with odd frequency.
// For every character, if it already exists in the set, it means we've seen it twice, so we remove it and add 2 to the count.
// If it doesn't exist in the set, we add it.
// At the end, if the set is not empty, we can use one of those characters as the center of the palindrome — so we add 1 to the count.

import java.util.HashSet;

public class LongestPalindrome {
    public int findMaxLen(String s){
        HashSet<Character> set = new HashSet<>();

        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(set.contains(ch)){
                set.remove(ch);
                count = count + 2;
            }else{
                set.add(ch);
            }
        }

        if(set.size() > 0){
            return count + 1;
        }

        return count;
    }
}
