import java.util.HashSet;

public class LongestPalindrome2 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();

        int count = 0;

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                count += 2;
                set.remove(c);
            }
        }

        if (set.isEmpty()) {
            return count;
        } else {
            return count + 1;
        }
    }
}

/**
 * Add first time occurrence to a hashSet and when encountered once again, increment the count by 2 and remove that character from the set.
 * if the set is not empty return count+1 or else count;
 * TC: O(n)
 * SC : O(1)
 */
