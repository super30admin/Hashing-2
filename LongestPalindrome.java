// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        int palindromeLength = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charSet.contains(c)) {
                charSet.add(c);
            } else {
                palindromeLength += 2;
                charSet.remove(c);
            }
        }
        if (!charSet.isEmpty()) {
            palindromeLength++;
        }
        return palindromeLength;
    }
}