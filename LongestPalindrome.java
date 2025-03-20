import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        boolean flag = false;

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char c : map.keySet()) {
            int frq = map.get(c);
            if (frq % 2 == 0) {
                count += frq;
            } else {
                count += frq - 1;
                flag = true;
            }
        }

        return flag ? count + 1 : count;
    }
}

/**
 * HashMap to keep track of character and its count (number of times it appeared in the string)
 * A flag to say if any odd count is present because in palindrome we can consider any one of the odd character
 * and all the evens contribute to a palindrome.
 * So we return the total count of even + 1 odd count if it is present.
 * TC : O(n) To traverse through input string and all the values in the map
 * SC: O(1) as we have lowercase and/or uppercase English letters only at most 52.
 */