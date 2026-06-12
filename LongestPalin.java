import java.util.*;

public class LongestPalin {
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (!hs.contains(c)) {
                hs.add(c);
            } else {
                count += 2;
                hs.remove(c);
            }
        }
        if (hs.size() > 0) {
            count +=1;
        }
        return count;
    }
}
