// Time Complexity : O(n), where n is the length of the input string `s`.
// Space Complexity : O(1), since the HashSet stores at most 52 characters (a-z, A-Z).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// HashSet-based greedy pairing approach.
// The idea is to greedily count character pairs:
// - Iterate through the string and add each character to a HashSet.
// - If the character is already in the set, it forms a pair, so we remove it and add 2 to the count.
// - At the end, if the set is not empty, it means there's at least one unpaired character left.
//   We can place exactly one such character in the center of the palindrome, so we add 1 to the count.
// This ensures we build the longest possible palindrome using the given characters.

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if(set.contains(c)){
                count+=2;
                set.remove(c);
            }else{
                set.add(c);
            }
        }

        if(!set.isEmpty()) count++;

        return count;
    }
}