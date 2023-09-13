class Solution {
    public int longestPalindrome(String s) {
        // Check if the input string is empty or null
        if (s.length() == 0 || s == null)
            return 0;

        // Create a HashSet to store characters
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        // Iterate through the characters in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is already in the set, it can be part of a palindrome
            if (set.contains(ch)) {
                set.remove(ch); // Remove the character from the set
                count += 2;     // Increment the palindrome count by 2 (for the current character and its pair)
            } else {
                set.add(ch);    // Add the character to the set
            }
        }

        // If there are any characters left in the set, they can be used as a center for an odd-length palindrome
        if (!set.isEmpty())
            return count + 1;
        else
            return count;
    }
}

// Time Complexity: O(N), where N is the length of the input string.
// Space Complexity: O(1), because the number of distinct alphabetic characters is limited, making the size of the HashSet constant.
