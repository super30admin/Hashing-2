import java.util.HashSet;

public class Palindrome {

    public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(c)) {
                count += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            return count + 1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        String s = "abccccdd";

        int result = longestPalindrome(s);

        System.out.println("Longest Palindrome Length: " + result);
    }
}


// a -> add
// b -> add
// c -> add
// c -> remove, count += 2
// c -> add
// c -> remove, count += 2
// d -> add
// d -> remove, count += 2

// count = 6, set = {a, b}
// Since set is not empty, answer = 6 + 1 = 7


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No