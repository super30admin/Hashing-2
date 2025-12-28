// Time Complexity : O(N), Go through all the elements to find the max length
// Space Complexity : O(N), keep all the sums in the map in the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach :
// A palindrome can have even number of characters or odd number of characters. Palindrome with total Odd number of
// characters is longer. To form the longest palindrome: we take everything from even counts of characters.
// And take the "even part" of odd counts: If a letter appears 5 times, you can still use 4 of them (2 on each side).
// And if there are odd number of characters in the string, add one to the result.
// Longest palindrome  => even count of chars + even count out of odd number of chars + 1 (if it has odd numbers of characters)
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) return 1;

        // Maintain a frequency map to maintain the characters and their count.
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < length; i++) {
            Character curr = s.charAt(i);
            if (frequencyMap.containsKey(curr)) {
                frequencyMap.put(curr, frequencyMap.get(curr) + 1);
            } else {
                frequencyMap.put(curr, 1);
            }
        }

        boolean hasOddChars = false;
        for (Integer count : frequencyMap.values()) {
            // if the count is even add to the max length as it is.
            if (count % 2 == 0) {
                result += count;
            } else {
                // if the count is odd, add to the max even value from it and set flag has odd characters to true
                result += count-1;
                hasOddChars = true;
            }
        }

        if(hasOddChars){
            result += 1;
        }
        return result;
    }
}
