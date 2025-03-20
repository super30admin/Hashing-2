public class LongestPalindrome3 {
    class Solution {
        public int longestPalindrome(String s) {

            char[] charArray = new char[100]; // null values -> 0

            int count = 0;

            for (char c : s.toCharArray()) {
                if (charArray[c - 'A'] != 0) {
                    count += 2;
                    charArray[c - 'A'] = 0;
                } else {
                    charArray[c - 'A'] = c;
                }
            }

            if (s.length() == count)
                return count;
            return count + 1;

        }
    }
}

//TC: O(n)
//SC: O(1)
