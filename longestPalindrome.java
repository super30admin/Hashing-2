// Time Complexity : O(n), n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * we add every new character in the set.
 * If a character is already present in the set, we increament the result value by 2 and remove the character from set.
 * At last if the set is not empty, we know we can add one character in the palindrome which can be at the centre of the sting and still the tsring will be palindrome.
 * increament result by 1;
 */
class Solution {
    public int longestPalindrome(String s) {

        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (set.contains(ch)) {
                result += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            result++;
        }

        return result;
    }
}