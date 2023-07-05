// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
import java.util.HashSet;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int result = 0;
        if(s == null || s.length() ==0) return result;
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray())
        {
           if(!charSet.contains(c))
           {
               charSet.add(c);
           }
           else {
               result += 2;
               charSet.remove(c);
           }
        }
        if (!charSet.isEmpty()) result++;
        return result;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(longestPalindrome(s));
    }

}
