// Time Complexity : O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashSet;
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (set.size() > 0) return count + 1;
        return count;
    }
}
