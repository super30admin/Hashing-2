class LongestPalindrome {
    /*
    Approach: For palindrome string we need each letter 2x times  and one letter can have 1 time.
    We can use set here.

    Time complexity: o(n) where n is string length
    Space complexity: o(1). Set will have at max constant number of characters
    */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
                count += 2;
            }
        }
        if (!set.isEmpty()) {
            count++;
        }
        return count;
    }
}

