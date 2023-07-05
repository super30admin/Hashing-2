cilass LongestPalindrome {
    // Space Complexity - O(N) 
    // Time Complexity - O(N)
    // chars with even frequency will form a valid palindrome of even length
    // chars with odd frequeny (or just 1 occurrence) can only be added at the center of an odd length palindrome
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char c : s.toCharArray()) {
            if (set.contains(c)) {
                count = count + 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            count++;
        }
        return count;
    }
}
