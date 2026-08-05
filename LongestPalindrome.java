
// Approach: Iterate through the characters of the given string and add them into a hash set, while adding, if you already find the element
// in the set, then incremenet the length by 2 and remove the character from the set. At last, check if the set is empty to identify odd count
// of characters and use it increment the lengthy by 1 or not.

// Time Complexity - O(n)
// Space Complexity - O(1)


class Solution {
    public int longestPalindrome(String s) {

        // Validate the inputs
        if (s == null || s.isEmpty()) {
            return 0;
        }
        else if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++)
        {
            // Add the element when it is not already present in the Hash Set
            if (!set.contains(s.charAt(i)))
            {
                set.add(s.charAt(i));
            }
            else
            {
                // If the character is found in the set, that means we have an even count, so increment length by 2 and remove the element from the set.
                length += 2;
                set.remove(s.charAt(i));
            }
        }

        // If the set is not empty, then we have an odd count within the set, which will be the middle element. So increment length by 1
        if (!set.isEmpty())
        {
            length++;
        }
        return length;
    }
}