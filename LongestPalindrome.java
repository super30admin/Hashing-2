import java.util.HashSet;

/**
 * Time Complexity: O(N)
 * Space Complexity : O(1)
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int counter = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashSet.contains(c)) {
                counter = counter + 2;
                hashSet.remove(c);
            } else {
                hashSet.add(c);
            }
        }
        if (hashSet.size() > 0) {
            counter += 1;
        }
        return counter;
    }
}
