import java.util.HashSet;
import java.util.Set;

/*
approach: store characters we see in a set, if we enounter same char again, we increment result by 2,
remove char from set.
time: O(n)
space: O(1)
 */

public class Problem3 {
    static int longestPalindrome(String s) {
        Set<Character> charsSeen = new HashSet<>();
        int result = 0;
        for (int i=0; i<s.length();i++) {
            char currChar = s.charAt(i);
            if (!charsSeen.contains(currChar)) {
                charsSeen.add(currChar);
            }
            else {
                result+=2;
                charsSeen.remove(currChar);
            }
        }
        return (!charsSeen.isEmpty())?result+1: result;
    }
    public static void main(String args[]) {
        System.out.println("max length "+longestPalindrome("abccccdd"));
    }
}
