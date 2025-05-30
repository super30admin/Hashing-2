
import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
        boolean hasOdd = false;

        for (int freq : map.values()) {
            answer += (freq / 2) * 2;
            if (freq % 2 == 1) hasOdd = true;
        }

        if (hasOdd) answer += 1;

        return answer;
    }

    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();

        String input1 = "abccccdd";
        String input2 = "a";
        String input3 = "AaBbCcDdEe";

        System.out.println("Longest palindrome that can be built from '" + input1 + "' = " + sol.longestPalindrome(input1)); // 7
        System.out.println("Longest palindrome that can be built from '" + input2 + "' = " + sol.longestPalindrome(input2)); // 1
        System.out.println("Longest palindrome that can be built from '" + input3 + "' = " + sol.longestPalindrome(input3)); // 1
    }
}
