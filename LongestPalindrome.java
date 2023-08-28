import java.util.HashSet;

// Time Complexity : O(n)
// Space Complexity : O(1)
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashSet<Character> hset = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hset.contains(ch)) {
                hset.remove(ch);
                count = count + 2;
            } else {
                hset.add(ch);
            }
        }
        if (!hset.isEmpty())
            count++;
        return count;
    }

    public static void main(String[] args) {
        String str = "abccccdd";
        int result = longestPalindrome(str);
        System.out.println(result);
    }
}
