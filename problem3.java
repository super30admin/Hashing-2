
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * Approach
 * we track the occurance of elements in a hashset
 * we check it the element occures twice we count that towards the palindrome
 */

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            count++;
        }
        return count;
    }
}