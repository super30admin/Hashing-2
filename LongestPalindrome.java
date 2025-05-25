import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    // -------------------------- Solution 1 --------------------------
    /**
     * prepare a frequency counter map and take all counts from it which are even,
     * subtract one from odd counts and to the result, and if we ever encounter an odd
     * counter our palindrome could have odd length by adding 1 char at the middle
     *
     * Time: O(n) Space O(1)
     */
    public int longestPalindrome1(String s) {
        int[] freq = new int[128];

        for(char c: s.toCharArray()) {
            freq[c]++;
        }

        boolean isOddLengthPossible = false;
        int result = 0;
        for(int i: freq) {
            if (i == 0) {
                continue;
            } else if (i == 1) {
                isOddLengthPossible = true;
            } else if (i % 2 == 0) {
                result += i;
            } else {
                result += i - 1;
                isOddLengthPossible = true;
            }
        }

        return isOddLengthPossible ? result + 1 : result;
    }

    // -------------------------- Solution 2 --------------------------

    /**
     * We can maintain a set to find Occurrence of pairs, if a character isn't present
     * in set add it, otherwise remove that character from set and increase result by 2.
     * Add the end if set has more than or equal to 1 character left in increase result by
     * 1 as it could be added as middle element
     *
     * Time: O(n) Space O(1)
     *
     */
    public int longestPalindrome(String s) {
        Set<Character> charSet = new HashSet<>();
        int result = 0;

        for (char c: s.toCharArray()) {
            if (charSet.contains(c)) {
                result += 2;
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }

        return charSet.size() > 0 ? result + 1 : result;
    }
}
