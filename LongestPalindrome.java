// Time Complexity : O(n) 
// Space Complexity : O(1) as the hashset cannot grow more than 100 in worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// This problem can be done using a Hashset
// we use Hashset to store the character in a string
// if the same character appears again we remove it from the set and add two to the count
// after the elements are traversed we check if the set is empty if not we add one to the count and return it as the answer

class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        Set<Character> set = new HashSet();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                count = count + 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count : count + 1;
    }
}